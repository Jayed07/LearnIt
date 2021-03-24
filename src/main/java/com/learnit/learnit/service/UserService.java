package com.learnit.learnit.service;

import com.learnit.learnit.model.entity.UserEntity;
import com.learnit.learnit.model.entity.UserRoleEntity;
import com.learnit.learnit.model.service.UserRegistrationServiceModel;
import com.learnit.learnit.view.UserManagementViewModel;

import java.util.List;
import java.util.Map;

public interface UserService {

    void seedUsers();

    void registerAndLoginUser(UserRegistrationServiceModel serviceModel);

    boolean userNameExists(String username);

    void changeUserRoleByUserId(Long id);

}
