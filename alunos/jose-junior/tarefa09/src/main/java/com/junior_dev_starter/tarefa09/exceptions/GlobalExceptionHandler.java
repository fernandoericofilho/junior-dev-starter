package com.junior_dev_starter.tarefa09.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    
    @ExceptionHandler(ClienteNotFoundException.class)
    public ResponseEntity<String> handleNotFound(ClienteNotFoundException exception) {
        return ResponseEntity.status(404).body(exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeral(Exception exception) {
        return ResponseEntity.status(500).body("Erro interno: " + exception.getMessage());
    }
}
