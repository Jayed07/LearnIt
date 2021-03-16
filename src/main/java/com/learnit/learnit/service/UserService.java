package com.learnit.learnit.service;

import com.learnit.learnit.model.service.UserRegistrationServiceModel;

public interface UserService {

    void seedUsers();

    void registerAndLoginUser(UserRegistrationServiceModel serviceModel);

    boolean userNameExists(String username);
}
