package com.learnit.learnit.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserProfileController {

    @GetMapping("/my-profile")
    public String userProfile() {
        return "profile";
    }
}
