package com.nnamanx.skylink.handler;

import com.nnamanx.skylink.exception.ApplicationException;
import com.nnamanx.skylink.model.dto.response.ExceptionResponse;
import com.nnamanx.skylink.model.enums.Exceptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ExceptionResponse> handle(ApplicationException applicationException) {

        Exceptions exceptions = applicationException.getExceptions();

        return ResponseEntity
                .status(exceptions.getHttpStatus())
                .body(ExceptionResponse.builder()
                        .message(exceptions.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build());
    }
}

