package com.example.qabul.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> exception(BadRequest badRequest){
        return ResponseEntity.badRequest().body(badRequest.getMessage());
    }
}
