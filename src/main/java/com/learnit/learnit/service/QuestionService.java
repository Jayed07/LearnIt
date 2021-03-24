package com.learnit.learnit.service;

import com.learnit.learnit.model.entity.AnswerEntity;
import com.learnit.learnit.model.service.QuestionAddServiceModel;
import com.learnit.learnit.view.ArticleViewModel;
import com.learnit.learnit.view.QuestionViewModel;

public interface QuestionService {
    void add(QuestionAddServiceModel questionAddServiceModel);

    QuestionViewModel findById(Long id);

}
