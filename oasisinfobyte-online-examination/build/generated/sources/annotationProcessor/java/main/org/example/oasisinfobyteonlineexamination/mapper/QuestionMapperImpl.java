package org.example.oasisinfobyteonlineexamination.mapper;

import javax.annotation.processing.Generated;
import org.example.oasisinfobyteonlineexamination.dto.QuestionDto;
import org.example.oasisinfobyteonlineexamination.entity.QuestionEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-07T19:52:19+0400",
    comments = "version: 1.6.2, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.11.1.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public QuestionEntity toEntity(QuestionDto questionDto) {
        if ( questionDto == null ) {
            return null;
        }

        QuestionEntity questionEntity = new QuestionEntity();

        questionEntity.setId( questionDto.getId() );
        questionEntity.setQuestionText( questionDto.getQuestionText() );
        questionEntity.setOptionA( questionDto.getOptionA() );
        questionEntity.setOptionB( questionDto.getOptionB() );
        questionEntity.setOptionC( questionDto.getOptionC() );
        questionEntity.setOptionD( questionDto.getOptionD() );
        questionEntity.setCorrectAnswer( questionDto.getCorrectAnswer() );
        questionEntity.setAnswer( questionDto.getAnswer() );

        return questionEntity;
    }

    @Override
    public QuestionDto toDto(QuestionEntity questionEntity) {
        if ( questionEntity == null ) {
            return null;
        }

        QuestionDto questionDto = new QuestionDto();

        questionDto.setId( questionEntity.getId() );
        questionDto.setQuestionText( questionEntity.getQuestionText() );
        questionDto.setOptionA( questionEntity.getOptionA() );
        questionDto.setOptionB( questionEntity.getOptionB() );
        questionDto.setOptionC( questionEntity.getOptionC() );
        questionDto.setOptionD( questionEntity.getOptionD() );
        questionDto.setCorrectAnswer( questionEntity.getCorrectAnswer() );
        questionDto.setAnswer( questionEntity.getAnswer() );

        return questionDto;
    }
}
