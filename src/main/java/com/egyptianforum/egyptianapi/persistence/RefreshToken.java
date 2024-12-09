package com.egyptianforum.egyptianapi.persistence;

import java.time.LocalDateTime;
import java.util.Date;

public class RefreshToken {
    private String token;
    private LocalDateTime expiresAt;
    private LocalDateTime createdAt;

    // Конструктор
    public RefreshToken(String token, LocalDateTime expiresAt, LocalDateTime createdAt) {
        this.token = token;
        this.expiresAt = expiresAt;
        this.createdAt = createdAt;
    }

    // Геттеры
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

