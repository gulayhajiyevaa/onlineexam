package org.example.oasisinfobyteonlineexamination.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.oasisinfobyteonlineexamination.entity.QuestionEntity;
import org.example.oasisinfobyteonlineexamination.service.ExamService;
import org.example.oasisinfobyteonlineexamination.service.QuestionService;
import org.example.oasisinfobyteonlineexamination.service.SessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("exam")
public class ExamController {
    private final ExamService examService;
    private final SessionService sessionService;
    private final QuestionService questionService;

    @PostMapping("/start")
    public ResponseEntity<List<QuestionEntity>> startExam(@RequestParam Long userId, HttpSession session) {
        // Start the session
        sessionService.startSession(session, userId);

        // Fetch questions for the exam
        List<QuestionEntity> questions = questionService.getQuestionsForExam(10);

        return ResponseEntity.ok(questions);
    }
}
