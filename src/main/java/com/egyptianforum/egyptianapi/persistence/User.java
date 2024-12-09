package com.egyptianforum.egyptianapi.persistence;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "userinfo")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Integer userId;

    @Column(name = "login")
    private String login;
    @Column(name = "passwordHash")
    private String passwordHash;
    @Column(name = "refreshToken")
    private String refreshToken;
    @Column(name = "tokenCreatedDt")
    private LocalDateTime tokenCreatedDt;
    @Column(name = "tokenExpires")
    private LocalDateTime tokenExpires;
    @Column(name = "role")
    private String role;

    public User(String login, String password, String role) {
        this.login = login;
        this.passwordHash = hashPassword(password);
        this.role = role == null ? "USER" : role;
    }

    public User() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (Objects.equals(this.role, "ADMIN")) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        }
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return login;
    }
    public String getLogin() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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


    public void setLogin(String username) {
        this.login = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
    public String getPassword() {
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


    public String getRole() { return role;}
    public void setRole(String role) {
        this.role = role;
    }
}
