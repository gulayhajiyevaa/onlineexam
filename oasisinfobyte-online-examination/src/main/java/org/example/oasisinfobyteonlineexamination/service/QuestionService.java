package org.example.oasisinfobyteonlineexamination.service;

import lombok.RequiredArgsConstructor;
import org.example.oasisinfobyteonlineexamination.entity.QuestionEntity;
import org.example.oasisinfobyteonlineexamination.mapper.QuestionMapper;
import org.example.oasisinfobyteonlineexamination.repository.QuestionRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepo questionRepo;
    private final QuestionMapper questionMapper;

    public List<QuestionEntity> getAllQuestions() {
        return questionRepo.findAll();
    }

    public QuestionEntity getQuestionById(Long id) {
        return questionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + id));
    }

    public QuestionEntity addQuestion(QuestionEntity question) {
        return questionRepo.save(question);
    }

    public QuestionEntity updateQuestion(Long id, QuestionEntity updatedQuestion) {
        QuestionEntity existingQuestion = getQuestionById(id);
        questionMapper.updateEntityFromDto(updatedQuestion, existingQuestion);
        return questionRepo.save(existingQuestion);
    }

    public List<QuestionEntity> getQuestionsForExam(int numberOfQuestions) {
        return questionRepo.findAllRandom();
    }

    public void deleteQuestion(Long id) {
        questionRepo.deleteById(id);
    }
}
