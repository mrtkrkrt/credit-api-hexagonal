package com.creditapi.infra.user.adapter.jpa;

import com.creditapi.domain.user.model.User;
import com.creditapi.domain.user.port.UserPort;
import com.creditapi.domain.user.usecase.RegisterUser;
import com.creditapi.infra.user.database.jpa.UserJpaRepository;
import com.creditapi.infra.user.database.jpa.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDataAdapter implements UserPort {

    private final UserJpaRepository userJpaRepository;

    @Override
    public Optional<User> retrieveUserByIdentityNumber(String identityNumber) {
        return Optional.ofNullable(userJpaRepository.findByIdentityNumber(identityNumber))
                .map(UserEntity::toDomain);
    }

    @Override
    public Optional<User> retrieveUserById(Long id) {
        return userJpaRepository.findById(id).map(UserEntity::toDomain);
    }

    @Override
    public User create(RegisterUser registerUser) {
        var userEntity = UserEntity.builder()
                .identityNumber(registerUser.getIdentityNumber())
                .firstName(registerUser.getFirstName())
                .lastName(registerUser.getLastName())
                .build();
        return userJpaRepository.save(userEntity).toDomain();
    }
}
