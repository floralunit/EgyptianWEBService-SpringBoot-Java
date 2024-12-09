package com.egyptianforum.egyptianapi.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findByQuestionId(Integer questionId);

    long countByQuestionId(Integer questionId);

    long countByUserId(Integer userId);

    void deleteByQuestionId(Integer questionId); // Метод для удаления комментариев по вопросу
}
