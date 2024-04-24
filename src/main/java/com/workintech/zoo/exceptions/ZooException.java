package com.workintech.zoo.exceptions;

import org.apache.http.HttpStatus;

public class ZooException extends RuntimeException{
    private HttpStatus httpStatus;

    public ZooException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
