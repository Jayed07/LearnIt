package com.learnit.learnit.model.service;

import com.learnit.learnit.model.entity.AnswerEntity;

public class QuestionAddServiceModel {

    private String author;
    private String content;
    private AnswerEntity answerEntity;

    public QuestionAddServiceModel() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

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
