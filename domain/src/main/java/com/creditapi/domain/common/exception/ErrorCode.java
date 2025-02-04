package com.creditapi.domain.common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    USER_ALREADY_EXISTS("user.already.exists");

    private final String messageKey;
    ErrorCode(String messageKey) {
        this.messageKey = messageKey;
    }
}
