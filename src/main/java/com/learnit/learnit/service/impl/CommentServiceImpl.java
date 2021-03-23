package com.learnit.learnit.service.impl;

import com.learnit.learnit.model.entity.CommentEntity;
import com.learnit.learnit.model.service.CommentAddServiceModel;
import com.learnit.learnit.repository.ArticleRepository;
import com.learnit.learnit.repository.CommentRepository;
import com.learnit.learnit.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;
    private final ArticleRepository articleRepository;

    public CommentServiceImpl(CommentRepository commentRepository, ModelMapper modelMapper, ArticleRepository articleRepository) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
        this.articleRepository = articleRepository;
    }


    @Override
    public void add(CommentAddServiceModel commentAddServiceModel, Authentication authentication, HttpServletRequest request) {

        CommentEntity commentEntity = modelMapper.map(commentAddServiceModel, CommentEntity.class);

        commentEntity.setAuthor(authentication.getName());

        String path = request.getRequestURI();
        char id = path.charAt(path.length() - 1);

        commentEntity.setArticle(articleRepository.findById(new Long(id)).orElseThrow(IllegalArgumentException::new));

        commentRepository.save(commentEntity);
    }
}
