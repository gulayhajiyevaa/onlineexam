package org.example.oasisinfobyteonlineexamination.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.oasisinfobyteonlineexamination.enums.RoleEnum;

@Entity
@Getter
@Setter
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RoleEnum roleEnume;

}
