package com.learnit.learnit.model.binding;

import com.learnit.learnit.model.entity.QuestionEntity;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class AnswerAddBindingModel {

    private String content;
    private QuestionEntity questionEntity;

    public AnswerAddBindingModel() {
    }

    @NotBlank
    @Column(name = "content", columnDefinition = "TEXT")
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
