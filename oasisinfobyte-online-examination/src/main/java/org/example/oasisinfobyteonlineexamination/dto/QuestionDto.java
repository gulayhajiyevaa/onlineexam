package org.example.oasisinfobyteonlineexamination.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import lombok.Data;
import org.example.oasisinfobyteonlineexamination.entity.AnswerEntity;

@Data
public class QuestionDto {
    private Long id;
    private String questionText;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctAnswer;
    private AnswerEntity answer;
}
