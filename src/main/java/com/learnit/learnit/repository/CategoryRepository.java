package com.learnit.learnit.repository;

import com.learnit.learnit.model.entity.CategoryEntity;
import com.learnit.learnit.model.entity.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

CategoryEntity findByName(CategoryName name);
}
