package org.example.oasisinfobyteonlineexamination.mapper;

import org.example.oasisinfobyteonlineexamination.dto.AuthRequest;
import org.example.oasisinfobyteonlineexamination.dto.AuthResponse;
import org.example.oasisinfobyteonlineexamination.dto.UserDto;
import org.example.oasisinfobyteonlineexamination.entity.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.security.core.userdetails.UserDetails;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(AuthRequest authRequest);
    AuthResponse toResponse(UserEntity userEntity);

}

