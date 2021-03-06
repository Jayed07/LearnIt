package com.learnit.learnit.model.view;

import com.learnit.learnit.model.entity.UserRoleEntity;

import java.util.List;

public class UserManagementViewModel {

    private String username;
    private List<UserRoleEntity> userRoleEntity;

    public UserManagementViewModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<UserRoleEntity> getUserRoleEntity() {
        return userRoleEntity;
    }

    public void setUserRoleEntity(List<UserRoleEntity> userRoleEntity) {
        this.userRoleEntity = userRoleEntity;
    }
}
