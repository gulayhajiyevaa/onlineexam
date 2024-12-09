package org.example.oasisinfobyteonlineexamination.mapper;

import org.example.oasisinfobyteonlineexamination.dto.AnswersDto;
import org.example.oasisinfobyteonlineexamination.entity.AnswerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

    AnswerEntity toEntity(AnswersDto answersDto);
    AnswersDto toDto(AnswerEntity answerEntity);
}
