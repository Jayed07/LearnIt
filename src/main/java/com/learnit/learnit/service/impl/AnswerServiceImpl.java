package com.learnit.learnit.service.impl;

import com.learnit.learnit.model.entity.AnswerEntity;
import com.learnit.learnit.model.entity.QuestionEntity;
import com.learnit.learnit.model.service.AnswerAddServiceModel;
import com.learnit.learnit.repository.AnswerRepository;
import com.learnit.learnit.repository.QuestionRepository;
import com.learnit.learnit.service.AnswerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final ModelMapper modelMapper;
    private final QuestionRepository questionRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository, ModelMapper modelMapper, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.modelMapper = modelMapper;
        this.questionRepository = questionRepository;
    }

    @Override
    public void add(AnswerAddServiceModel answerAddServiceModel, QuestionEntity questionEntity) {
        AnswerEntity answerEntity = modelMapper.map(answerAddServiceModel, AnswerEntity.class);


        answerEntity.setQuestionEntity(questionEntity);
        answerRepository.save(answerEntity);
        questionEntity.setAnswerEntity(answerEntity);
        questionRepository.save(questionEntity);
    }

    @Override
    public AnswerEntity findById(Long id) {

        return answerRepository.findById(id).
                orElse(null);
    }
}
