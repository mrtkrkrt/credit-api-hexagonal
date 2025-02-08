package com.creditapi.domain.common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    USER_ALREADY_EXISTS("User already exists"), USER_NOT_FOUND("User not found");

    private final String message;
    ErrorCode(String message) {
        this.message = message;
    }
}
