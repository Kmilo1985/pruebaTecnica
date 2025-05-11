
package com.api.pruebatecnica.crud.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleBadRequest(BadRequestException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<String> handleInternal(Exception ex) {
        return ResponseEntity.status(500).body("Error interno del servidor");
    }
}