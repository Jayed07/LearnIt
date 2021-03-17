package com.learnit.learnit.service;

import com.learnit.learnit.model.entity.CategoryEntity;
import com.learnit.learnit.model.entity.enums.CategoryName;

import java.util.Map;

public interface CategoryService {

    void seedCategories();

    Map<String, String> getAllCategories();

    CategoryEntity findByName(CategoryName categoryName);
}
