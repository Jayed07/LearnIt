package com.learnit.learnit.model.service;

public class CommentAddServiceModel {

    private String author;
    private String content;

    public CommentAddServiceModel() {
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
}
