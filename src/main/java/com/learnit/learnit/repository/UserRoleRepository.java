package com.learnit.learnit.repository;

import com.learnit.learnit.model.entity.UserRoleEntity;
import com.learnit.learnit.model.entity.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

    Optional<UserRoleEntity> findByRole(UserRole role);
}
