package com.learnit.learnit.model.entity;

import com.learnit.learnit.model.entity.enums.CategoryName;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

    private CategoryName name;
    private String description;

    public CategoryEntity() {
    }


    @Enumerated(EnumType.STRING)
    public CategoryName getName() {
        return name;
    }

    public CategoryEntity setName(CategoryName name) {
        this.name = name;
        return this;
    }

    @Column(name = "description", columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

