package com.learnit.learnit.service.impl;

import com.learnit.learnit.model.entity.CategoryEntity;
import com.learnit.learnit.model.entity.enums.CategoryName;
import com.learnit.learnit.repository.CategoryRepository;
import com.learnit.learnit.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories() {
        if (categoryRepository.count() == 0) {

            CategoryName[] categoryNames = CategoryName.values();

            for (CategoryName categoryName : categoryNames) {
                CategoryEntity categoryEntity = new CategoryEntity();
                categoryEntity.setName(categoryName);
                categoryEntity.setDescription("Some " + categoryName.toString().toLowerCase() + " category description.");
                categoryRepository.save(categoryEntity);

            }

        }

    }

    @Override
    public Map<String, String> getAllCategories() {

        Map<String, String> allCategories = new LinkedHashMap<>();

        for (CategoryName value : CategoryName.values()) {
            CategoryEntity categoryEntity = categoryRepository.findByName(value);
            allCategories.put(categoryEntity.getName().toString(), categoryEntity.getDescription());

        }

        return allCategories;
    }

    @Override
    public CategoryEntity findByName(CategoryName categoryName) {
        return categoryRepository.findByName(categoryName);

    }
}
