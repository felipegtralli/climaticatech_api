package com.climaticatech.api.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception e, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), e.getMessage(), request.getDescription(false));
        
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception e, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), e.getMessage(), request.getDescription(false));
        
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }
 
}
