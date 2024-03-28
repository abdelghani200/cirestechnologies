package com.cirestechnologies.cirestechnologies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsernameUsedException extends RuntimeException{
    public UsernameUsedException(String message){
        super(message);
    }
}
