package org.example.oasisinfobyteonlineexamination.dto;

import jakarta.persistence.*;
import lombok.Data;
import org.example.oasisinfobyteonlineexamination.enums.RoleEnum;
import org.springframework.boot.convert.DataSizeUnit;

@Data
public class UserDto {
    private Long id;
    private String email;
    private String username;
    private String password;
    private RoleEnum role;
}
