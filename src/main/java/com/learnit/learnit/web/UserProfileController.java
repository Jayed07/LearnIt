package com.learnit.learnit.web;

import com.learnit.learnit.repository.ArticleRepository;
import com.learnit.learnit.repository.QuestionRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserProfileController {

    private final ArticleRepository articleRepository;
    private final QuestionRepository questionRepository;

    public UserProfileController(ArticleRepository articleRepository, QuestionRepository questionRepository) {
        this.articleRepository = articleRepository;
        this.questionRepository = questionRepository;
    }

    @GetMapping("/my-profile")
    public String userProfile(Model model) {

        String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();

            model.addAttribute("articles", articleRepository.findAllByAuthor(currentUserName));
            model.addAttribute("questions", questionRepository.findAllByAuthor(currentUserName));

        return "profile";
    }
}
