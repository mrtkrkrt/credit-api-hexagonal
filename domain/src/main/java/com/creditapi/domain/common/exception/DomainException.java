package com.creditapi.domain.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomainException extends RuntimeException {

    private final String key;
    private final String[] args;

    public DomainException(String key) {
        super(key);
        this.key = key;
        args = new String[0];
    }

    public DomainException(String key, String... args) {
        super(key);
        this.key = key;
        this.args = args;
    }
}