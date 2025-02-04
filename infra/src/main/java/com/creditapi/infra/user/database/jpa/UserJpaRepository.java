package com.creditapi.infra.user.database.jpa;

import com.creditapi.infra.user.database.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByIdentityNumber(String identityNumber);
}
