package com.learnit.learnit.repository;

import com.learnit.learnit.model.entity.UserEntity;
import com.learnit.learnit.model.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String userName);

    UserRoleEntity findAllByUsername(String username);
}
