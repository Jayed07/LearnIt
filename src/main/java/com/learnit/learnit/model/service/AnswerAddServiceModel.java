package com.learnit.learnit.model.service;

import com.learnit.learnit.model.entity.QuestionEntity;
import com.learnit.learnit.model.entity.enums.CategoryName;

public class AnswerAddServiceModel {

    private Long id;
    private String content;
    private QuestionEntity questionEntity;

    public AnswerAddServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public QuestionEntity getQuestionEntity() {
        return questionEntity;
    }

    public void setQuestionEntity(QuestionEntity questionEntity) {
        this.questionEntity = questionEntity;
    }

}
