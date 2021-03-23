package com.learnit.learnit.model.binding;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class QuestionAddBindingModel {

    private String author;
    private String content;

    public QuestionAddBindingModel() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @NotBlank
    @Column(columnDefinition = "TEXT")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
