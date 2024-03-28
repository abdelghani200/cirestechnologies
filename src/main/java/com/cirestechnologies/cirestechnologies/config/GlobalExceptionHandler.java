package com.cirestechnologies.cirestechnologies.config;

import com.cirestechnologies.cirestechnologies.exceptions.CountValueInvalidException;
import com.cirestechnologies.cirestechnologies.exceptions.EmailUsedException;
import com.cirestechnologies.cirestechnologies.exceptions.UsernameUsedException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleUsernameNotFoundException(UsernameNotFoundException e) {
        return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailUsedException.class)
    public ResponseEntity<Map<String, String>> handleEmailAlreadyInUseException(EmailUsedException e) {
        return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(UsernameUsedException.class)
    public ResponseEntity<Map<String, String>> handleUsernameAlreadyInUseException(UsernameUsedException e) {
        return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Map<String, String>> handleBadRequestException(BadRequestException e) {
        return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CountValueInvalidException.class)
    public ResponseEntity<Map<String, String>> handleInvalidCountValueException(CountValueInvalidException e) {
        return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.FORBIDDEN);
    }

}
