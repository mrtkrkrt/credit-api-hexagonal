package com.creditapi.domain.common.usecase;


public interface VoidUseCaseHandler<T extends UseCase> {

    void handle(T useCase);
}
