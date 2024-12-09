package com.egyptianforum.egyptianapi.service;

import com.egyptianforum.egyptianapi.persistence.*;

import java.util.List;

public interface QuestionCommentService {
    Question createQuestion(Question question);
    Comment createComment(Comment comment);
    List<Question> getAllQuestions();
    List<Comment> getAllComments();
    List<Comment> getCommentsByQuestionId(Integer questionId);

    Comment addCommentToQuestion(Comment comment, Integer questionId);
    long countCommentsByQuestionId(Integer questionId);
    long countCommentsByUserId(Integer userId);
    void deleteQuestion(Integer questionId);
    void deleteComment(Integer commentId);
}

