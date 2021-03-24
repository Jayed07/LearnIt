package com.learnit.learnit.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class QuestionEntity extends BaseEntity{

    private String author;
    private String content;
    private AnswerEntity answerEntity;

    public QuestionEntity() {
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

    @OneToOne
    public AnswerEntity getAnswerEntity() {
        return answerEntity;
    }

    public void setAnswerEntity(AnswerEntity answerEntity) {
        this.answerEntity = answerEntity;
    }


}
