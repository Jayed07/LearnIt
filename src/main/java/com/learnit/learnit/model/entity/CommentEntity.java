package com.learnit.learnit.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class CommentEntity extends BaseEntity {

    private String author;
    private String content;
    private ArticleEntity articleEntity;

    public CommentEntity() {
    }

    @Column(name = "author", nullable = false)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name = "content", nullable = false)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @ManyToOne
    public ArticleEntity getArticle() {
        return articleEntity;
    }

    public void setArticle(ArticleEntity articleEntity) {
        this.articleEntity = articleEntity;
    }
}
