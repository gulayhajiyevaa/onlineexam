package org.example.oasisinfobyteonlineexamination.mapper;

import javax.annotation.processing.Generated;
import org.example.oasisinfobyteonlineexamination.dto.AuthRequest;
import org.example.oasisinfobyteonlineexamination.dto.AuthResponse;
import org.example.oasisinfobyteonlineexamination.entity.UserEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-07T18:33:50+0400",
    comments = "version: 1.6.2, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.11.1.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity toEntity(AuthRequest authRequest) {
        if ( authRequest == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setEmail( authRequest.getEmail() );
        userEntity.setUsername( authRequest.getUsername() );
        userEntity.setPassword( authRequest.getPassword() );

        return userEntity;
    }

    @Override
    public AuthResponse toResponse(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        AuthResponse authResponse = new AuthResponse();

        authResponse.setId( userEntity.getId() );
        authResponse.setUsername( userEntity.getUsername() );
        authResponse.setEmail( userEntity.getEmail() );

        return authResponse;
    }
}
