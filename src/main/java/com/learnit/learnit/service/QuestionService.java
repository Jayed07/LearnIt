package com.learnit.learnit.service;

import com.learnit.learnit.model.service.QuestionAddServiceModel;
import com.learnit.learnit.model.view.ArticleViewModel;
import com.learnit.learnit.model.view.QuestionViewModel;

public interface QuestionService {
    void add(QuestionAddServiceModel questionAddServiceModel);

    QuestionViewModel findById(Long id);

}
