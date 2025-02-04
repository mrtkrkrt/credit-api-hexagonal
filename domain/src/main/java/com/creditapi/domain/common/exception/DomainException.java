package com.creditapi.domain.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomainException extends RuntimeException {

    private final String message;

    public DomainException(String message) {
        super(message);
        this.message = message;
    }
}