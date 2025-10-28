package com.fernandesdraw.exceptions;

public class EmployeeDoesNotExistException extends RuntimeException {

    public EmployeeDoesNotExistException() {
        super("Employee does not exist");
    }

    public EmployeeDoesNotExistException(String message) {
        super(message);
    }
}
