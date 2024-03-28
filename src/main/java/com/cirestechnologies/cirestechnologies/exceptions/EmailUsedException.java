package com.cirestechnologies.cirestechnologies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmailUsedException extends RuntimeException{
    public EmailUsedException(String message){
        super(message);
    }
}
