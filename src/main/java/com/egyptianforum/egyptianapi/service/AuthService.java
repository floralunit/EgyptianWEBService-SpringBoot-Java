package com.egyptianforum.egyptianapi.service;

import com.egyptianforum.egyptianapi.persistence.*;
import com.egyptianforum.egyptianapi.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.List;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(UserDto request) throws Exception {
        byte[] passwordSalt = new byte[16];
        new SecureRandom().nextBytes(passwordSalt);

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPasswordHash(request.getPassword());

        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        List<User> foundUsers = userRepository.findByUsername(username);
        return foundUsers.isEmpty() ? null : foundUsers.get(0);
    }


    public byte[] createPasswordHash(String password, byte[] passwordSalt) throws Exception {
        // Создаем HMAC с использованием SHA-512
        Mac mac = Mac.getInstance("HmacSHA512");
        SecretKeySpec secretKeySpec = new SecretKeySpec(passwordSalt, "HmacSHA512");
        mac.init(secretKeySpec);

        // Вычисляем хеш пароля
        return mac.doFinal(password.getBytes("UTF-8"));
    }


    private JwtUtil jwtUtil = new JwtUtil();

    //private HttpServletResponse response;


    public AuthResponseDto login(UserDto request) {

        User user = findByUsername(request.getUsername());
        if (user == null) {
            return new AuthResponseDto("Пользователь не найден!", false);
        }

        if (!user.getPasswordHash().equals(User.hashPassword(request.getPassword()))) {
            return new AuthResponseDto("Неправильно введен пароль!", false);
        }

        String token = jwtUtil.createToken(user);
        RefreshToken refreshToken = createRefreshToken();
        setRefreshToken(refreshToken, user);

        return new AuthResponseDto(true, token, user.getUserId(), user.getUsername(),
                user.getRefreshToken(), user.getTokenExpires(), user.getRole(),
                "Успешная авторизация!");
    }

    private RefreshToken createRefreshToken() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[64];
        random.nextBytes(bytes);
        String token = Base64.getEncoder().encodeToString(bytes);

        LocalDateTime expires = LocalDateTime.now().plus(7, ChronoUnit.DAYS);
        return new RefreshToken(token, expires, LocalDateTime.now());
    }

    private void setRefreshToken(RefreshToken refreshToken, User user) {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        if (response != null) {
            response.addCookie(new Cookie("refreshToken", refreshToken.getToken()));
        }
        user.setRefreshToken(refreshToken.getToken());
        System.out.println("токен: " + refreshToken.getToken());
        user.setTokenCreatedDt(refreshToken.getCreatedAt());
        user.setTokenExpires(refreshToken.getExpiresAt());

        userRepository.save(user);
    }

    public AuthResponseDto refreshToken() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String refreshToken = getCookieValue(request);
        User user = userRepository.findByRefreshToken(refreshToken);
        if (user == null) {
            return new AuthResponseDto("Invalid Refresh Token", false);
        } else if (user.getTokenExpires().isBefore(LocalDateTime.now())) {
            return new AuthResponseDto("Token expired.", false);
        }

        String token = jwtUtil.createToken(user);
        RefreshToken newRefreshToken = createRefreshToken();
        setRefreshToken(newRefreshToken, user);

        return new AuthResponseDto(true, token, user.getUserId(), user.getUsername(),
                newRefreshToken.getToken(), newRefreshToken.getExpiresAt(), user.getRole(),
                "Успешное обновление токена!");
    }

    public String getCookieValue(HttpServletRequest request) {
        // Получаем все cookies из текущего запроса
        Cookie[] cookies = request.getCookies();

        // Проверяем, есть ли cookies
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                // Если имя cookie совпадает с "refreshToken", возвращаем его значение
                if ("refreshToken".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }

        // Если cookie с таким именем не найден, возвращаем null
        return null; // или return ""; в зависимости от ваших требований
    }
}
