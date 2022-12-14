package com.gihanz.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedLoginException extends RuntimeException{

    public UnauthorizedLoginException(String message) {
        super(message);
    }
}
