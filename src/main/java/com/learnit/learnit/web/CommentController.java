package com.learnit.learnit.web;

import com.learnit.learnit.model.binding.CommentAddBindingModel;
import com.learnit.learnit.model.service.ArticleAddServiceModel;
import com.learnit.learnit.model.service.CommentAddServiceModel;
import com.learnit.learnit.service.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class CommentController {

    private final ArticleService articleService;
    private final ModelMapper modelMapper;

    public CommentController(ArticleService articleService, ModelMapper modelMapper) {
        this.articleService = articleService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute("commentBindingModel")
    public CommentAddBindingModel createBindingModel() {
        return new CommentAddBindingModel();
    }

    @GetMapping("/details")
    public String addComment() {
        return "details";
    }

    @PostMapping("/details")
    public String addCommentConfirm
        (@Valid CommentAddBindingModel commentAddBindingModel,
                BindingResult bindingResult,
                RedirectAttributes redirectAttributes) {
            if (bindingResult.hasErrors()) {
                redirectAttributes.addFlashAttribute("commentAddBindingModel", commentAddBindingModel);
                redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.commentAddBindingModel", bindingResult);

                return "redirect:details";
            }


            articleService
                    .addComment(modelMapper.map(commentAddBindingModel, CommentAddServiceModel.class));

            return "redirect:details";
        }
    }



