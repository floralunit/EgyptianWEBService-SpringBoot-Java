package com.egyptianforum.egyptianapi.resource;

import com.egyptianforum.egyptianapi.persistence.AuthResponseDto;
import com.egyptianforum.egyptianapi.persistence.User;
import com.egyptianforum.egyptianapi.persistence.UserDto;
import com.egyptianforum.egyptianapi.persistence.UserRepository;
import com.egyptianforum.egyptianapi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserDto request) throws Exception {
        User existingUser = authService.findByUsername(request.getLogin());
        if (existingUser != null) {
            return ResponseEntity.badRequest().body("Пользователь с таким ником уже зарегистрирован!");
        }

        User user = authService.registerUser(request);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponseDto> login(@RequestBody UserDto request) {
        AuthResponseDto response = authService.login(request);

        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().body(response);
    }

    @GetMapping("/refresh-token")
    public ResponseEntity<AuthResponseDto> RefreshToken() {
        AuthResponseDto response = authService.refreshToken();
        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().body(response);
    }

    @PostMapping("/profile")
    public ResponseEntity<?> getUserInfo(@RequestParam String username) {
        UserDetails user = authService.findByUsername(username);

        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.badRequest().body("Пользователь не найден!");
    }
}
