package com.learnit.learnit.model.binding;

import com.learnit.learnit.model.entity.AnswerEntity;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

    @NotBlank(message = "Cannot be empty.")
    @Size(min = 5, max = 150, message = "Question must be between 5 and 150 characters long.")
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
