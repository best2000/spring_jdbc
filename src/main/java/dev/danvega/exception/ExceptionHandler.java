package dev.danvega.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {CustomException.class})
    public ResponseEntity<Object> handleException(CustomException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        //create exception object (for display in response)
        ExceptionModel mainException = new ExceptionModel(e.getMessage(),e, badRequest,ZonedDateTime.now());

        return new ResponseEntity<>(mainException,badRequest);
    }
}
