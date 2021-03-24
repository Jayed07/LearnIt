package com.learnit.learnit.service.impl;

import com.learnit.learnit.model.entity.UserRoleEntity;
import com.learnit.learnit.model.entity.UserEntity;
import com.learnit.learnit.model.entity.enums.UserRole;
import com.learnit.learnit.model.service.UserRegistrationServiceModel;
import com.learnit.learnit.repository.UserRoleRepository;
import com.learnit.learnit.repository.UserRepository;
import com.learnit.learnit.service.UserService;
import com.learnit.learnit.view.QuestionViewModel;
import com.learnit.learnit.view.UserManagementViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final LearnItUserService learnItUserService;

    public UserServiceImpl(UserRoleRepository userRoleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper, LearnItUserService learnItUserService) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.learnItUserService = learnItUserService;
    }

    @Override
    public void seedUsers() {
        if (userRepository.count() == 0) {

            UserRoleEntity adminUserRoleEntity = new UserRoleEntity().setRole(UserRole.ADMIN);
            UserRoleEntity userRoleEntity = new UserRoleEntity().setRole(UserRole.USER);

            userRoleRepository.saveAll(List.of(adminUserRoleEntity, userRoleEntity));

            UserEntity admin = new UserEntity().setUsername("admin").setEmail("admin@abv.bg").setPassword(passwordEncoder.encode("12345"));
            UserEntity userEntity = new UserEntity().setUsername("user").setEmail("user@abv.bg").setPassword(passwordEncoder.encode("12345"));
            admin.setRole(List.of(adminUserRoleEntity, userRoleEntity));
            userEntity.setRole(List.of(userRoleEntity));

            userRepository.saveAll(List.of(admin, userEntity));
        }
    }

    @Override
    public void registerAndLoginUser(UserRegistrationServiceModel serviceModel) {
        UserEntity newUserEntity = modelMapper.map(serviceModel, UserEntity.class);
        newUserEntity.setPassword(passwordEncoder.encode(serviceModel.getPassword()));

        UserRoleEntity userRoleEntity = userRoleRepository.
                findByRole(UserRole.USER).orElseThrow(
                () -> new IllegalStateException("USER role not found. Please seed the roles."));

        newUserEntity.addRole(userRoleEntity);

        newUserEntity = userRepository.save(newUserEntity);

        UserDetails principal = learnItUserService.loadUserByUsername(newUserEntity.getUsername());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                newUserEntity.getPassword(),
                principal.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public boolean userNameExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    public void changeUserRoleByUserId(Long id) {
        UserRoleEntity userRoleEntity = userRoleRepository.findByRole(UserRole.USER).orElse(null);
        UserRoleEntity adminUserRoleEntity = userRoleRepository.findByRole(UserRole.ADMIN).orElse(null);

        UserEntity user = userRepository.findById(id).orElse(null);

        assert user != null;
        if(user.getRole().size() == 2) {
            assert userRoleEntity != null;
            user.setRole(List.of(userRoleEntity));
        } else {
            assert adminUserRoleEntity != null;
            assert userRoleEntity != null;
            user.setRole(List.of(adminUserRoleEntity, userRoleEntity));
        }

        userRepository.save(user);
    }

}