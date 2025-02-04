package com.creditapi.domain.common.usecase;


public interface UseCasePublisher {

    <R, T extends UseCase> R publish(Class<R> returnClass, T useCase);

    <R, T extends UseCase> void publish(T useCase);

    <R, T extends UseCase> void publishAsync(T useCase);

    <R> R publish(Class<R> returnClass);
}
