package com.learnit.learnit.repository;

import com.learnit.learnit.model.entity.ArticleEntity;
import com.learnit.learnit.model.entity.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

    List<ArticleEntity> findAllByCategory_Name(CategoryName categoryName);

    List<ArticleEntity> findAllByAuthor(String author);

}
