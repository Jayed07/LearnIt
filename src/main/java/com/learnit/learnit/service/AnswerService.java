package com.learnit.learnit.service;

import com.learnit.learnit.model.entity.AnswerEntity;
import com.learnit.learnit.model.entity.QuestionEntity;
import com.learnit.learnit.model.service.AnswerAddServiceModel;
import com.learnit.learnit.model.service.QuestionAddServiceModel;

public interface AnswerService {

    void add(AnswerAddServiceModel answerAddServiceModel, QuestionEntity questionEntity);

    AnswerEntity findById(Long id);
}
