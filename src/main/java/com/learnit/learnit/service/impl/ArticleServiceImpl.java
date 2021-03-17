package com.learnit.learnit.service.impl;

import com.learnit.learnit.model.entity.ArticleEntity;
import com.learnit.learnit.model.service.ArticleAddServiceModel;
import com.learnit.learnit.repository.ArticleRepository;
import com.learnit.learnit.service.ArticleService;
import com.learnit.learnit.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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

        articleRepository.save(articleEntity);
    }
}
