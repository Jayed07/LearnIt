package com.learnit.learnit.model.binding;

import com.learnit.learnit.model.entity.QuestionEntity;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AnswerAddBindingModel {

    private Long id;
    private String content;
    private QuestionEntity questionEntity;

    public AnswerAddBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotBlank(message = "Cannot be empty.")
    @Size(min = 5, max = 150, message = "Answer must be between 5 and 150 characters long.")
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
