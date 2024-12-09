package com.egyptianforum.egyptianapi.service;

import com.egyptianforum.egyptianapi.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuestionCommentServiceImpl implements QuestionCommentService {

    private final QuestionRepository questionRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public QuestionCommentServiceImpl(QuestionRepository questionRepository, CommentRepository commentRepository) {
        this.questionRepository = questionRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public Question createQuestion(Question question) {
        question.setDtCreated(LocalDateTime.now());
        return questionRepository.save(question);
    }

    @Override
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> getCommentsByQuestionId(Integer questionId) {
        return commentRepository.findByQuestionId(questionId);
    }

    @Override
    public Comment addCommentToQuestion(Comment comment, Integer questionId) {
        comment.setQuestionId(questionId);
        comment.setCreatedDt(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    @Override
    public long countCommentsByQuestionId(Integer questionId) {
        return commentRepository.countByQuestionId(questionId);
    }

    @Override
    public long countCommentsByUserId(Integer userId) {
        return commentRepository.countByUserId(userId);
    }

    @Transactional
    @Override
    public void deleteQuestion(Integer questionId) {
        questionRepository.deleteById(questionId);
        commentRepository.deleteByQuestionId(questionId);
    }

    @Transactional
    @Override
    public void deleteComment(Integer commentId) {
        commentRepository.deleteById(commentId);
    }
}
