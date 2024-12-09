package org.example.oasisinfobyteonlineexamination.repository;

import org.example.oasisinfobyteonlineexamination.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface QuestionRepo extends JpaRepository<QuestionEntity, Long> {

    Optional<QuestionEntity> findById(Long id);
    @Query("SELECT q FROM QuestionEntity q ORDER BY RANDOM()")
    List<QuestionEntity> findAllRandom();
}
