package com.learnit.learnit.repository;

import com.learnit.learnit.model.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {
    List<QuestionEntity> findAllByAuthor(String currentUserName);
}
