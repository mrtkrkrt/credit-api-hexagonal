package com.creditapi.domain.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomainException extends RuntimeException {

    private final String messageKey;

    public DomainException(String messageKey) {
        super(messageKey);
        this.messageKey = messageKey;
    }
}