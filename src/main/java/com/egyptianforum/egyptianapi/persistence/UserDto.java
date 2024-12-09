package com.egyptianforum.egyptianapi.persistence;

import jakarta.persistence.*;


public class UserDto {
    private String username;
    private String password;
    public boolean isAdmin;

    public UserDto(Integer userId, String username, boolean isAdmin) {
        username = username;
        userId = userId;
        isAdmin = isAdmin;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean role) {
        this.isAdmin = role;
    }
}
