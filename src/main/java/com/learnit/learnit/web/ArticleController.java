package com.learnit.learnit.web;

import com.learnit.learnit.model.binding.ArticleAddBindingModel;
import com.learnit.learnit.model.entity.enums.CategoryName;
import com.learnit.learnit.model.service.ArticleAddServiceModel;
import com.learnit.learnit.service.ArticleService;
import com.learnit.learnit.view.ArticleViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ArticleController {

    private final ArticleService articleService;
    private final ModelMapper modelMapper;

    public ArticleController(ArticleService articleService, ModelMapper modelMapper) {
        this.articleService = articleService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add-article")
    public String addArticle(Model model) {

        if (!model.containsAttribute("articleAddBindingModel")) {
            model.addAttribute("articleAddBindingModel", new ArticleAddBindingModel());
        }

        return "add-article";
    }

    @PostMapping("/add-article")
    public String addArticleConfirm(@Valid ArticleAddBindingModel articleAddBindingModel,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("articleAddBindingModel", articleAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.articleAddBindingModel", bindingResult);

            return "redirect:add-article";
        }


        articleService
                .add(modelMapper.map(articleAddBindingModel, ArticleAddServiceModel.class));

        return "redirect:/";
    }


    @GetMapping("/details/{id}")
    public String articleDetails(@PathVariable Long id, Model model) {

        ArticleViewModel articleViewModel = articleService.findById(id);

        model.addAttribute("article", articleViewModel);

        return "details";
    }
}
