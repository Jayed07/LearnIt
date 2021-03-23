package com.learnit.learnit.web;

import com.learnit.learnit.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String adminPanel() {
        return "admin";
    }

    @GetMapping("/admin-user")
    public String adminUser(Model model) {

        model.addAttribute("usersMap", userService.getAllUsersUsernamesAndRoles());
        return "admin-user";
    }
    @GetMapping("/admin-contact")
    public String adminContact() {
        return "admin-contact";
    }

}
