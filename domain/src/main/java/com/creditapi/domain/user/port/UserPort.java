package com.creditapi.domain.user.port;

import com.creditapi.domain.user.model.User;
import com.creditapi.domain.user.usecase.RegisterUser;

import java.util.Optional;

public interface UserPort {
    Optional<User> retrieveUserByIdentityNumber(String identityNumber);

    User create(RegisterUser registerUser);
}
