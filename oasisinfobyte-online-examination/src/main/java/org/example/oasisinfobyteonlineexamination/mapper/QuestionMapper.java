package org.example.oasisinfobyteonlineexamination.mapper;

import org.example.oasisinfobyteonlineexamination.dto.QuestionDto;
import org.example.oasisinfobyteonlineexamination.entity.QuestionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    QuestionEntity toEntity(QuestionDto questionDto);
    QuestionDto toDto(QuestionEntity questionEntity);

     default void updateEntityFromDto(QuestionEntity source, QuestionEntity target) {
        target.setQuestionText(source.getQuestionText());
        target.setOptionA(source.getOptionA());
        target.setOptionB(source.getOptionB());
        target.setOptionC(source.getOptionC());
        target.setOptionD(source.getOptionD());
        target.setCorrectAnswer(source.getCorrectAnswer());
    }
}
