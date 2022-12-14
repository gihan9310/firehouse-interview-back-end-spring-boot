package com.gihanz.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleProjectObjectException(UnauthorizedLoginException exception, WebRequest request) {

        UnauthorizedLoginExceptionResponse response = new UnauthorizedLoginExceptionResponse(exception.getMessage(),401);
        return new ResponseEntity(response, HttpStatus.UNAUTHORIZED);
    }

}
