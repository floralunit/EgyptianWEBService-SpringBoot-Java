package com.egyptianforum.egyptianapi.security;

import com.egyptianforum.egyptianapi.persistence.User;
import com.egyptianforum.egyptianapi.persistence.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.ExpiredJwtException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class JwtUtil {

    private String SECRET_KEY = "your_secret_key"; // Замените на ваш секретный ключ
    private long JWT_EXPIRATION_DAYS = 7; // Время жизни токена (7 дней)
    private UserRepository userRepository;

    // Метод для создания токена
    public String createToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", user.getUsername());
        // Добавьте другие необходимые данные о пользователе

        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime expirationDateTime = now.plusDays(JWT_EXPIRATION_DAYS).atZone(ZoneId.systemDefault());

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(Date.from(now.atZone(ZoneId.systemDefault()).toInstant()))
                .setExpiration(Date.from(expirationDateTime.toInstant()))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    // Метод для извлечения имени пользователя из токена
    public String extractUsername(String token) {
        return extractAllClaims(token).get("username").toString();
    }

    // Метод для извлечения всех данных из токена
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    // Метод для проверки, истек ли токен
    public boolean isTokenExpired(String token) {
        try {
            return extractAllClaims(token).getExpiration().before(new Date());
        } catch (ExpiredJwtException e) {
            return true; // Если токен истек, возвращаем true
        }
    }

    // Метод для проверки валидности токена
    public boolean validateToken(String token, User user) {
        final String username = extractUsername(token);
        return (username.equals(user.getUsername()) && !isTokenExpired(token));
    }
}
