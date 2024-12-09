package org.example.oasisinfobyteonlineexamination.service;

import lombok.RequiredArgsConstructor;
import org.example.oasisinfobyteonlineexamination.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamService {
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final UserRepo userRepo;
    private final UserService userService;

//
//    public void startExam(Long id){
//        questionService.getAllQuestions();
//        answerService.calculateScore(id);
//    }
}
