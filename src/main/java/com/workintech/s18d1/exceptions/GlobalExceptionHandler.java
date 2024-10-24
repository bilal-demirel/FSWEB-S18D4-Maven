package com.workintech.s18d1.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BurgerException.class)
    public ResponseEntity<BurgerErrorResponse> handleBurgerErrorException(BurgerException ex) {
        logger.error("Error occurred: {}", ex.getMessage());
        BurgerErrorResponse response = new BurgerErrorResponse(ex.getMessage());
        return new ResponseEntity<>(response, ex.getHttpStatus());
    }
}
