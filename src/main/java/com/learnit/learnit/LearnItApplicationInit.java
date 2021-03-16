package com.learnit.learnit;

import com.learnit.learnit.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LearnItApplicationInit implements CommandLineRunner {

    private final UserService userService;

    public LearnItApplicationInit(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        userService.seedUsers();
        //TODO: seed Categories

    }
}
