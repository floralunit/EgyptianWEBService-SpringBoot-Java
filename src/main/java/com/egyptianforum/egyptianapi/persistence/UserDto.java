package com.egyptianforum.egyptianapi.persistence;

import jakarta.persistence.*;


public class UserDto {
    private String login;
    private String password;
    private String role;

    public UserDto(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    // Getter для login
    public String getLogin() {
        return login;
    }

    // Setter для login
    public void setLogin(String login) {
        this.login = login;
    }

    // Getter для password
    public String getPassword() {
        return password;
    }

    // Setter для password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter для role
    public String getRole() {
        return role;
    }

    // Setter для role
    public void setRole(String role) {
        this.role = role;
    }

}
