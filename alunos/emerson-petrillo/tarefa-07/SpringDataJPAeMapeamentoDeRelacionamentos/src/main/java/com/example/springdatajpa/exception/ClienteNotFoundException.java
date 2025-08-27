package com.example.springdatajpa.exception;

public class ClienteNotFoundException extends RuntimeException {

    public ClienteNotFoundException(Long id) {
        super("Cliente com o seguinte id não encontrado: " + id);
    }
}