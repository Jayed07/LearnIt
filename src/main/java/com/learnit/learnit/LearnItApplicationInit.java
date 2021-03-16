package com.learnit.learnit;

import com.learnit.learnit.service.CategoryService;
import com.learnit.learnit.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LearnItApplicationInit implements CommandLineRunner {

    private final UserService userService;
    private final CategoryService categoryService;

    public LearnItApplicationInit(UserService userService, CategoryService categoryService) {
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        userService.seedUsers();
        categoryService.seedCategories();

    }
}
