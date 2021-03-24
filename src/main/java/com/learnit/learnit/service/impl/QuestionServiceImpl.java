package com.learnit.learnit.service.impl;

import com.learnit.learnit.model.entity.AnswerEntity;
import com.learnit.learnit.model.entity.QuestionEntity;
import com.learnit.learnit.model.service.QuestionAddServiceModel;
import com.learnit.learnit.repository.AnswerRepository;
import com.learnit.learnit.repository.QuestionRepository;
import com.learnit.learnit.service.QuestionService;
import com.learnit.learnit.view.QuestionViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;

    public QuestionServiceImpl(QuestionRepository questionRepository, ModelMapper modelMapper) {
        this.questionRepository = questionRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void add(QuestionAddServiceModel questionAddServiceModel) {
        QuestionEntity questionEntity = modelMapper.map(questionAddServiceModel, QuestionEntity.class);

        String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        questionEntity.setAuthor(currentUserName);

        questionRepository.save(questionEntity);
    }

    @Override
    public QuestionViewModel findById(Long id) {
        return questionRepository.findById(id)
                .map(questionEntity -> {
                    QuestionViewModel questionViewModel = modelMapper
                            .map(questionEntity, QuestionViewModel.class);
                    return questionViewModel;
                }).orElseThrow(IllegalArgumentException::new);
    }



}
