package com.factweavers.authenticationservice.domain;

import lombok.Getter;

@Getter
public class CustomRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 3L;
    private  String errorCode;

    public CustomRuntimeException(String message, String errorCode) {
        super(message);
        this.errorCode=errorCode;
    }
}