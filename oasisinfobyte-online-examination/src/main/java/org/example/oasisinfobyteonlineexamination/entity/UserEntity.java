package org.example.oasisinfobyteonlineexamination.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.oasisinfobyteonlineexamination.enums.RoleEnum;
@Entity
@Getter
@Setter
@Table(name = "users_info")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

}
