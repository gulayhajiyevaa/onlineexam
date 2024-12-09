package org.example.oasisinfobyteonlineexamination.repository;

import org.example.oasisinfobyteonlineexamination.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByEmail(String email);
    boolean existsByEmail(String email);
    Optional<UserEntity> findById(Long id);
}
