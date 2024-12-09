package com.egyptianforum.egyptianapi.persistence;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "comment") // Название таблицы в базе данных
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Название столбца
    private Integer id;

    @Column(name = "user_id") // Название столбца
    private Integer userId;

    @Column(name = "question_id") // Название столбца
    private Integer questionId;

    @Column(name = "created_dt") // Название столбца
    private LocalDateTime createdDt;

    @Column(name = "username") // Название столбца
    private String username;

    @Column(name = "description") // Название столбца
    private String description;

    // Геттеры и сеттеры
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public LocalDateTime getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(LocalDateTime createdDt) {
        this.createdDt = createdDt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
