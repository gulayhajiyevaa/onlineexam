package org.example.oasisinfobyteonlineexamination.controller;

import lombok.RequiredArgsConstructor;
import org.example.oasisinfobyteonlineexamination.entity.QuestionEntity;
import org.example.oasisinfobyteonlineexamination.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;


    @GetMapping
    public ResponseEntity<List<QuestionEntity>> getAllQuestions() {
        List<QuestionEntity> questions = questionService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionEntity> getQuestionById(@PathVariable Long id) {
        QuestionEntity question = questionService.getQuestionById(id);
        return ResponseEntity.ok(question);
    }

    @PostMapping
    public ResponseEntity<QuestionEntity> addQuestion(@RequestBody QuestionEntity question) {
        QuestionEntity createdQuestion = questionService.addQuestion(question);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuestion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionEntity> updateQuestion(@PathVariable Long id, @RequestBody QuestionEntity updatedQuestion) {
        QuestionEntity updated = questionService.updateQuestion(id, updatedQuestion);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }
}
