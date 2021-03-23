package com.learnit.learnit.model.binding;

import com.learnit.learnit.model.entity.ArticleEntity;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class CommentAddBindingModel {

    private String author;
    private String content;
    private ArticleEntity articleEntity;

    public CommentAddBindingModel() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @NotBlank
    @Column(name = "content", columnDefinition = "TEXT")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArticleEntity getArticleEntity() {
        return articleEntity;
    }

    public void setArticleEntity(ArticleEntity articleEntity) {
        this.articleEntity = articleEntity;
    }
}
