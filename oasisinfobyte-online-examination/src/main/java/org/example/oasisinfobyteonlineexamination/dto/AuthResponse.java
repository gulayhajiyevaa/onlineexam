package org.example.oasisinfobyteonlineexamination.dto;

import lombok.Data;
import org.example.oasisinfobyteonlineexamination.entity.UserRole;

@Data
public class AuthResponse {
    private Long id;
    private String username;
    private String email;

}
