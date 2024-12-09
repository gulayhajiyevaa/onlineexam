package org.example.oasisinfobyteonlineexamination.service;

import lombok.RequiredArgsConstructor;
import org.example.oasisinfobyteonlineexamination.entity.AnswerEntity;
import org.example.oasisinfobyteonlineexamination.entity.QuestionEntity;
import org.example.oasisinfobyteonlineexamination.entity.UserEntity;
import org.example.oasisinfobyteonlineexamination.repository.AnswerRepo;
import org.example.oasisinfobyteonlineexamination.repository.QuestionRepo;
import org.example.oasisinfobyteonlineexamination.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepo answerRepo;
    private final UserRepo userRepo;
    private final QuestionRepo questionRepo;

    public AnswerEntity saveAnswer(Long userId, Long questionId, String selectedAnswer) {
        UserEntity user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        QuestionEntity question = questionRepo.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + questionId));

        AnswerEntity answer = new AnswerEntity();
        answer.setUser(user);
        answer.setQuestion(question);
        answer.setSelectedAnswer(selectedAnswer);

        return answerRepo.save(answer);
    }

    public List<AnswerEntity> getAnswersByUser(Long userId) {
        return answerRepo.findByUserId(userId);
    }

    public int calculateScore(Long userId) {
        List<AnswerEntity> answers = getAnswersByUser(userId);
        int score = 0;

        for (AnswerEntity answer : answers) {
            if (answer.getSelectedAnswer().equals(answer.getQuestion().getCorrectAnswer())) {
                score++;
            }
        }
        return score;
    }

    public AnswerEntity saveOrUpdateAnswer(AnswerEntity answerEntity) {
        return answerRepo.save(answerEntity);
    }
}
