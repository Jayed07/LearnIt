package com.learnit.learnit.service.impl;

import com.learnit.learnit.model.entity.ArticleEntity;
import com.learnit.learnit.model.entity.enums.CategoryName;
import com.learnit.learnit.model.service.ArticleAddServiceModel;
import com.learnit.learnit.repository.ArticleRepository;
import com.learnit.learnit.service.ArticleService;
import com.learnit.learnit.service.CategoryService;
import com.learnit.learnit.view.ArticleViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;


    public ArticleServiceImpl(ArticleRepository articleRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.articleRepository = articleRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void add(ArticleAddServiceModel articleAddServiceModel) {
        ArticleEntity articleEntity = modelMapper.map(articleAddServiceModel, ArticleEntity.class);

        articleEntity.setCategory(categoryService.findByName(articleAddServiceModel.getCategoryName()));
        String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        articleEntity.setAuthor(currentUserName);

        articleRepository.save(articleEntity);
    }

    @Override
    public List<ArticleViewModel> findArticlesByCategoryName(CategoryName categoryName) {
        return articleRepository.findAllByCategory_Name(categoryName)
                .stream().map(articleEntity -> modelMapper.map(articleEntity, ArticleViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public ArticleViewModel findById(Long id) {

        return articleRepository.findById(id)
                .map(articleEntity -> {
                    ArticleViewModel articleViewModel = modelMapper
                            .map(articleEntity, ArticleViewModel.class);
                    return articleViewModel;
                }).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public void addComment(CommentAddServiceModel commentAddServiceModel) {
        CommentEntity commentEntity = modelMapper.map(commentAddServiceModel, CommentEntity.class);

        // TODO
    }

    @Override
    public void deleteById(Long id) {
        articleRepository.deleteById(id);
    }
}
