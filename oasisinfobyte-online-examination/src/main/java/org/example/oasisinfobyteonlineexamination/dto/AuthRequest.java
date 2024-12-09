package org.example.oasisinfobyteonlineexamination.dto;

import lombok.Data;
import org.example.oasisinfobyteonlineexamination.enums.RoleEnum;

@Data
public class AuthRequest {
    private String username;
    private String email;
    private String password;
}
