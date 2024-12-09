package com.egyptianforum.egyptianapi.persistence;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Date;

public class AuthResponseDto {
    private boolean success = false;
    private String message = "";
    private int userId;
    private String username = "";
    private String role = "";
    private String token = "";
    private String refreshToken = "";
    private LocalDateTime tokenExpires;

    // Конструкторы
    public AuthResponseDto() {
    }
    public AuthResponseDto(String message, boolean success) {
        this.message = message;
        this.success = success;
        this.userId = 0;  // или другое значение по умолчанию
        this.username = "";
        this.role = "";
        this.token = "";
        this.refreshToken = "";
        this.tokenExpires = null;
    }

    public AuthResponseDto(boolean success, String token, int userId, String username,
                           String refreshToken, LocalDateTime tokenExpires, String role, String message) {
        this.success = success;
        this.message = message;
        this.userId = userId;
        this.username = username;
        this.role = role;
        this.token = token;
        this.refreshToken = refreshToken;
        this.tokenExpires = tokenExpires;
    }


    // Геттеры и сеттеры
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public LocalDateTime getTokenExpires() {
        return tokenExpires;
    }

    public void setTokenExpires(LocalDateTime tokenExpires) {
        this.tokenExpires = tokenExpires;
    }
}
