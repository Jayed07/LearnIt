package com.learnit.learnit.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "articles")
public class ArticleEntity extends BaseEntity {

    private String name;
    private String content;
    private String imageUrl;
    private CategoryEntity categoryEntity;
    private List<CommentEntity> commentEntities;
    private String author;
    //TODO: add Author field == session user

    public ArticleEntity() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "content", columnDefinition = "TEXT", nullable = false)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "image_url", nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @ManyToOne
    public CategoryEntity getCategory() {
        return categoryEntity;
    }

    public void setCategory(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    @OneToMany
    public List<CommentEntity> getComments() {
        return commentEntities;
    }

    public void setComments(List<CommentEntity> commentEntities) {
        this.commentEntities = commentEntities;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

