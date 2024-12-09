package com.egyptianforum.egyptianapi.resource;

import com.egyptianforum.egyptianapi.persistence.*;
import com.egyptianforum.egyptianapi.service.QuestionCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionCommentController {

    private final QuestionCommentService questionCommentService;

    @Autowired
    public QuestionCommentController(QuestionCommentService questionCommentService) {
        this.questionCommentService = questionCommentService;
    }

    @PostMapping("/questions/add")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        Question createdQuestion = questionCommentService.createQuestion(question);
        return ResponseEntity.ok(createdQuestion);
    }

    @PostMapping("/createComment")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        Comment createdComment = questionCommentService.createComment(comment);
        return ResponseEntity.ok(createdComment);
    }

    @GetMapping("/questions/all")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = questionCommentService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }
    @GetMapping("/comments/all")
    public ResponseEntity<List<Comment>> getAllComments() {
        List<Comment> comments = questionCommentService.getAllComments();
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/comments/{questionId}")
    public ResponseEntity<List<Comment>> getCommentsByQuestionId(@PathVariable Integer questionId) {
        List<Comment> comments = questionCommentService.getCommentsByQuestionId(questionId);
        return ResponseEntity.ok(comments);
    }

    // Новый метод для добавления комментария к вопросу
    @PostMapping("/comments/add/{id}")
    public ResponseEntity<List<Comment>> addComment(@RequestBody Comment comment, @PathVariable Integer id) {
        Comment createdComment = questionCommentService.addCommentToQuestion(comment, id);
        List<Comment> comments = questionCommentService.getCommentsByQuestionId(id);
        return ResponseEntity.ok(comments);
    }

    // Новый метод для подсчета комментариев в обсуждении по Id
    @PostMapping("/comments/count/{id}")
    public ResponseEntity<Long> commentsQuestionCount(@PathVariable Integer id) {
        long count = questionCommentService.countCommentsByQuestionId(id);
        return ResponseEntity.ok(count);
    }

    // Новый метод для подсчета комментариев пользователя по Id
    @PostMapping("/comments/count/user/{id}")
    public ResponseEntity<Long> commentsUserCount(@PathVariable Integer id) {
        long count = questionCommentService.countCommentsByUserId(id);
        return ResponseEntity.ok(count);
    }

    // Новый метод для удаления обсуждения
    @DeleteMapping("/questions/delete/{id}")
    public ResponseEntity<List<Question>> deleteQuestion(@PathVariable Integer id) {
        questionCommentService.deleteQuestion(id);
        List<Question> questions = questionCommentService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }

    @DeleteMapping("/comments/delete/{id}")
    public ResponseEntity<List<Comment>> deleteComment(@PathVariable Integer id) {
        questionCommentService.deleteComment(id);
        List<Comment> comments = questionCommentService.getCommentsByQuestionId(id);
        return ResponseEntity.ok(comments);
    }
}
