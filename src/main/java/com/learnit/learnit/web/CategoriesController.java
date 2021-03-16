package com.learnit.learnit.web;

import com.learnit.learnit.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoriesController {

    private final CategoryService categoryService;

    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("categories")
    public String getCategories(Model model) {

        model.addAttribute("categoriesMap", categoryService.getAllCategories());

        return "categories";
    }
}
