package com.learnit.learnit.web;

import com.learnit.learnit.model.entity.enums.CategoryName;
import com.learnit.learnit.service.ArticleService;
import com.learnit.learnit.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoriesController {

    private final CategoryService categoryService;
    private final ArticleService articleService;

    public CategoriesController(CategoryService categoryService, ArticleService articleService) {
        this.categoryService = categoryService;
        this.articleService = articleService;
    }

    @GetMapping("/categories")
    public String getCategories(Model model) {

        model.addAttribute("categoriesMap", categoryService.getAllCategories());

        return "categories";
    }

    @GetMapping("/categories/animals")
    public String getAnimalsArticles(Model model) {

        model.addAttribute("animals", articleService.findArticlesByCategoryName(CategoryName.ANIMALS));

        return "animals";
    }

    @GetMapping("/categories/astronomy")
    public String getAstronomyArticles(Model model) {

        model.addAttribute("astronomy", articleService.findArticlesByCategoryName(CategoryName.ASTRONOMY));

        return "astronomy";
    }

    @GetMapping("/categories/auto")
    public String getAutoArticles(Model model) {

        model.addAttribute("auto", articleService.findArticlesByCategoryName(CategoryName.AUTO));

        return "auto";
    }

    @GetMapping("/categories/computers")
    public String getComputersArticles(Model model) {

        model.addAttribute("computers", articleService.findArticlesByCategoryName(CategoryName.COMPUTERS));

        return "computers";
    }

    @GetMapping("/categories/sports")
    public String getSportsArticles(Model model) {

        model.addAttribute("sports", articleService.findArticlesByCategoryName(CategoryName.SPORTS));

        return "sports";
    }
}
