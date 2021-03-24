package com.learnit.learnit.model.binding;

import com.learnit.learnit.model.entity.AnswerEntity;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class QuestionAddBindingModel {

    private String author;
    private String content;
    private AnswerEntity answerEntity;

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

    public AnswerEntity getAnswerEntity() {
        return answerEntity;
    }

    public void setAnswerEntity(AnswerEntity answerEntity) {
        this.answerEntity = answerEntity;
    }
}
