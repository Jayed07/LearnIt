package com.learnit.learnit.service;

import com.learnit.learnit.model.service.UserRegistrationServiceModel;
import com.learnit.learnit.model.view.UserManagementViewModel;

public interface UserService {

    void seedUsers();

    void registerAndLoginUser(UserRegistrationServiceModel serviceModel);

    boolean userNameExists(String username);

    void changeUserRoleByUserId(Long id);

}
