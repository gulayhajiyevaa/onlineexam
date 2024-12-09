package org.example.oasisinfobyteonlineexamination.controller;

import lombok.RequiredArgsConstructor;
import org.example.oasisinfobyteonlineexamination.entity.AnswerEntity;
import org.example.oasisinfobyteonlineexamination.service.AnswerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("answer")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;
    @PostMapping
    public AnswerEntity saveAnswer(@RequestParam Long userId, @RequestParam Long questionId, @RequestParam String selectedAnswer) {
        return answerService.saveAnswer(userId, questionId, selectedAnswer);
    }

    @GetMapping("{userId}")
    public List<AnswerEntity> getAnswersByUser(@PathVariable Long userId) {
        return answerService.getAnswersByUser(userId);
    }

    @GetMapping("{userId}/score")
    public int calculateScore(@PathVariable Long userId) {
        return answerService.calculateScore(userId);
    }
    @PostMapping("/submit")
    public ResponseEntity<String> submitAnswer(@RequestBody AnswerEntity answerEntity) {
        answerService.saveOrUpdateAnswer(answerEntity);
        return ResponseEntity.ok("Answer submitted successfully.");
    }

}
