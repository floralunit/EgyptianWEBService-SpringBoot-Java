package com.egyptianforum.egyptianapi.persistence;

import jakarta.persistence.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

@Entity
@Table(name = "userinfo")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Integer userId;

    @Column(name = "username")
    private String username;
    @Column(name = "passwordHash")
    private String passwordHash;
    @Column(name = "refreshToken")
    private String refreshToken;
    @Column(name = "tokenCreatedDt")
    private LocalDateTime tokenCreatedDt;
    @Column(name = "tokenExpires")
    private LocalDateTime tokenExpires;
    @Column(name = "role")
    public String role;

    // Конструкторы
    public User() {
        this.username = "";
        this.passwordHash = "";
        this.role = "";
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Ошибка хеширования пароля", e);
        }
    }

    // Геттеры и сеттеры
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String password) {
        this.passwordHash = hashPassword(password);
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public LocalDateTime getTokenCreatedDt() {
        return tokenCreatedDt;
    }

    public void setTokenCreatedDt(LocalDateTime tokenCreatedDt) {
        this.tokenCreatedDt = tokenCreatedDt;
    }

    public LocalDateTime getTokenExpires() {
        return tokenExpires;
    }

    public void setTokenExpires(LocalDateTime tokenExpires) {
        this.tokenExpires = tokenExpires;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
