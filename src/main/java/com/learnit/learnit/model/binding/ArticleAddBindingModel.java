package com.learnit.learnit.model.binding;

import com.learnit.learnit.model.entity.CategoryEntity;
import com.learnit.learnit.model.entity.enums.CategoryName;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ArticleAddBindingModel {

    private String name;
    private String content;
    private String imageUrl;
    private CategoryName categoryName;

    public ArticleAddBindingModel() {
    }

    @NotBlank(message = "Cannot be empty.")
    @Size(min = 3, max = 30, message = "Article name must be between 3 and 30 characters long.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank(message = "Cannot be empty.")
    @Column(name = "content", columnDefinition = "TEXT")
    @Size(min = 10, message = "Content of article must be at least 10 characters long.")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @NotBlank(message = "Cannot be empty.")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public CategoryName getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(CategoryName categoryName) {
        this.categoryName = categoryName;
    }
}
