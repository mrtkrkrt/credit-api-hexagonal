package com.creditapi.domain.common.usecase;


public interface UseCaseHandler<R, T extends UseCase> {

    R handle(T useCase);
}
