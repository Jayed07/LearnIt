package com.learnit.learnit.model.service;

import com.learnit.learnit.model.entity.CategoryEntity;
import com.learnit.learnit.model.entity.enums.CategoryName;

public class ArticleAddServiceModel {

    private String name;
    private String content;
    private String imageUrl;
    private CategoryName categoryName;

    public ArticleAddServiceModel() {
    }

    public CategoryName getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(CategoryName categoryName) {
        this.categoryName = categoryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
