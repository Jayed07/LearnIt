package com.learnit.learnit.service;

import com.learnit.learnit.model.service.CommentAddServiceModel;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface CommentService {

    void add(CommentAddServiceModel commentAddServiceModel, Authentication authentication, HttpServletRequest request);
}
