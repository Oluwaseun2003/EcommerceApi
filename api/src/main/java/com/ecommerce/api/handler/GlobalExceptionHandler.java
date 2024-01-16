package com.ecommerce.api.handler;

import com.ecommerce.api.dto.CustomError;
import com.ecommerce.api.exceptions.RecordNotFoundException;
import com.ecommerce.api.exceptions.UserAlreadyExist;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Order(1)
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(UserAlreadyExist.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<CustomError> userAlreadyExist(UserAlreadyExist ex){
        CustomError customError = new CustomError(HttpStatus.CONFLICT.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(customError);
    }

    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<CustomError> productNotFound(RecordNotFoundException ex) {
        CustomError customError = new CustomError(HttpStatus.NOT_FOUND.value(),  ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(customError);
    }
}
