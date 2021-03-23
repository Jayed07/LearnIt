package com.learnit.learnit.service;

import com.learnit.learnit.model.entity.enums.CategoryName;
import com.learnit.learnit.model.service.ArticleAddServiceModel;
import com.learnit.learnit.model.service.CommentAddServiceModel;
import com.learnit.learnit.view.ArticleViewModel;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ArticleService {

    void add(ArticleAddServiceModel articleAddServiceModel);

    List<ArticleViewModel> findArticlesByCategoryName(CategoryName categoryName);

    ArticleViewModel findById(Long id);

    void addComment(CommentAddServiceModel commentAddServiceModel);

    void deleteById(Long id);
}
