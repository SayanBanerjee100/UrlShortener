package com.example.urlshortener.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(UrlNotFoundException.class)
    public ResponseEntity<String> handleException(UrlNotFoundException ex) {

        return ResponseEntity.status(404).body(ex.getMessage());
    }
}