package com.example.springboot.exception;

public class ClienteNotFoundException extends RuntimeException {

    public ClienteNotFoundException(Long id) {
        super("Cliente com o seguinte id não encontrado: " + id);
    }
}