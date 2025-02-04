package com.creditapi.domain.user;

import com.creditapi.domain.common.exception.DomainException;
import com.creditapi.domain.common.exception.ErrorCode;
import com.creditapi.domain.common.usecase.DomainComponent;
import com.creditapi.domain.common.usecase.ObservableUseCasePublisher;
import com.creditapi.domain.common.usecase.UseCaseHandler;
import com.creditapi.domain.user.model.User;
import com.creditapi.domain.user.port.UserPort;
import com.creditapi.domain.user.usecase.RegisterUser;
import jakarta.transaction.Transactional;

@DomainComponent
public class UserRegisterUseCaseHandler extends ObservableUseCasePublisher implements UseCaseHandler<User, RegisterUser> {

    private final UserPort userPort;

    public UserRegisterUseCaseHandler(UserPort userPort) {
        this.userPort = userPort;
        register(RegisterUser.class, this);
    }

    @Override
    @Transactional
    public User handle(RegisterUser useCase) {
        checkUserExists(useCase.getIdentityNumber());
        return userPort.create(useCase);
    }

    private void checkUserExists(String identityNumber) {
        if (userPort.retrieveUserByIdentityNumber(identityNumber).isPresent()) {
            throw new DomainException(ErrorCode.USER_ALREADY_EXISTS.getMessageKey());
        }
    }
}
