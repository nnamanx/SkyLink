package com.nnamanx.skylink.exception;

import com.nnamanx.skylink.model.enums.Exceptions;
import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {
    private final Exceptions exceptions;

    public ApplicationException(Exceptions exceptions) {

        super(exceptions.getMessage());
        this.exceptions = exceptions;
    }
}
