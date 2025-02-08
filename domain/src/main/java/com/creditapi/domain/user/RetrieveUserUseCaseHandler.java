package com.creditapi.domain.user;

import com.creditapi.domain.common.exception.DomainException;
import com.creditapi.domain.common.exception.ErrorCode;
import com.creditapi.domain.common.usecase.DomainComponent;
import com.creditapi.domain.common.usecase.ObservableUseCasePublisher;
import com.creditapi.domain.common.usecase.UseCaseHandler;
import com.creditapi.domain.user.model.User;
import com.creditapi.domain.user.port.UserPort;
import com.creditapi.domain.user.usecase.RetrieveUser;

@DomainComponent
public class RetrieveUserUseCaseHandler extends ObservableUseCasePublisher implements UseCaseHandler<User, RetrieveUser> {

    private final UserPort userPort;

    public RetrieveUserUseCaseHandler(UserPort userPort) {
        this.userPort = userPort;
        register(RetrieveUser.class, this);
    }

    @Override
    public User handle(RetrieveUser useCase) {
        return userPort.retrieveUserById(useCase.userId()).orElseThrow(() -> new DomainException(ErrorCode.USER_NOT_FOUND.getMessage()));
    }
}
