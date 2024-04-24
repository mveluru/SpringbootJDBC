package com.brite.springbootjdbc.employee;

import org.springframework.http.HttpStatus;

public class EmployeeException {

    private final String message;
    private final HttpStatus status;
    private final Throwable throwable;


    public EmployeeException(String message, HttpStatus status, Throwable throwable) {
        this.message = message;
        this.status = status;
        this.throwable = throwable;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Throwable getThrowable() {
        return throwable;
    }
}
