package com.learnit.learnit.web;

import com.learnit.learnit.model.binding.ArticleAddBindingModel;
import com.learnit.learnit.model.binding.QuestionAddBindingModel;
import com.learnit.learnit.model.service.ArticleAddServiceModel;
import com.learnit.learnit.model.service.QuestionAddServiceModel;
import com.learnit.learnit.service.QuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AskTheAdminController {

    private final QuestionService questionService;
    private final ModelMapper modelMapper;

    public AskTheAdminController(QuestionService questionService, ModelMapper modelMapper) {
        this.questionService = questionService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/ask-the-admin")
    public String askTheAdmin(Model model) {


        if (!model.containsAttribute("questionAddBindingModel")) {
            model.addAttribute("questionAddBindingModel", new QuestionAddBindingModel());
        }

        return "ask-the-admin";
    }

    @PostMapping("/ask-the-admin")
    public String askTheAdminConfirm(@Valid QuestionAddBindingModel questionAddBindingModel,
                                     BindingResult bindingResult,
                                     RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("questionAddBindingModel", questionAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.questionAddBindingModel", bindingResult);

            return "redirect:/";
        }


        questionService
                .add(modelMapper.map(questionAddBindingModel, QuestionAddServiceModel.class));

        return "redirect:/";
    }
}
