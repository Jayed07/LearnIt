package com.learnit.learnit.web;

import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String adminPanel() {
        return "admin";
    }

    @GetMapping("/admin-user")
    public String adminUser() {
        return "admin-user";
    }
    @GetMapping("/admin-contact")
    public String adminContact() {
        return "admin-contact";
    }
    @GetMapping("/admin-article")
    public String adminArticle() {
        return "admin-article";
    }
}
