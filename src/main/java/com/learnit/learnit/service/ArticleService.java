package com.learnit.learnit.service;

import com.learnit.learnit.model.entity.enums.CategoryName;
import com.learnit.learnit.model.service.ArticleAddServiceModel;
import com.learnit.learnit.view.ArticleViewModel;

import java.util.List;

public interface ArticleService {

    void add(ArticleAddServiceModel articleAddServiceModel);

    List<ArticleViewModel> findArticlesByCategoryName(CategoryName categoryName);
}
