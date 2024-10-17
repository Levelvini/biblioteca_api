package com.levelvini.biblioteca.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourseNotFoundException extends RuntimeException{
    public ResourseNotFoundException(String message) {
        super(message);
    }

    public ResourseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourseNotFoundException(Throwable cause) {
        super(cause);
    }

    public ResourseNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ResourseNotFoundException() {
    }
}
