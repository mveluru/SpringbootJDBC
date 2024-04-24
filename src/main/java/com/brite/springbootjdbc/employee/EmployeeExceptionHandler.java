package com.brite.springbootjdbc.employee;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler(value = {EmployeeNotFoundException.class})
    public ResponseEntity<Object> employeeNotFoundHandler(EmployeeNotFoundException employeeNotFoundException){
        EmployeeException employeeException= new EmployeeException(
                employeeNotFoundException.getMessage(),
                HttpStatus.NOT_FOUND,
                employeeNotFoundException.getCause()
                );
        return new ResponseEntity<>(employeeException,HttpStatus.NOT_FOUND);
    }
}
