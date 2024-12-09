package org.example.oasisinfobyteonlineexamination.mapper;

import javax.annotation.processing.Generated;
import org.example.oasisinfobyteonlineexamination.dto.AnswersDto;
import org.example.oasisinfobyteonlineexamination.entity.AnswerEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-07T19:52:19+0400",
    comments = "version: 1.6.2, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.11.1.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class AnswerMapperImpl implements AnswerMapper {

    @Override
    public AnswerEntity toEntity(AnswersDto answersDto) {
        if ( answersDto == null ) {
            return null;
        }

        AnswerEntity answerEntity = new AnswerEntity();

        return answerEntity;
    }

    @Override
    public AnswersDto toDto(AnswerEntity answerEntity) {
        if ( answerEntity == null ) {
            return null;
        }

        AnswersDto answersDto = new AnswersDto();

        return answersDto;
    }
}
