package org.example.oasisinfobyteonlineexamination.repository;

import org.example.oasisinfobyteonlineexamination.entity.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnswerRepo extends JpaRepository<AnswerEntity, Long> {

    // Custom query to fetch answers by user ID
    List<AnswerEntity> findByUserId(Long userId);

    // Optional: Find an answer by user and question for uniqueness
    Optional<AnswerEntity> findByUserIdAndQuestionId(Long userId, Long questionId);
}

