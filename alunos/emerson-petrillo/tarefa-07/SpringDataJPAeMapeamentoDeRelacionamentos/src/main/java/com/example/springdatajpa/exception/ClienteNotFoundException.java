package com.example.springdatajpa.exception;

public class ClienteNotFoundException extends RuntimeException {

    public ClienteNotFoundException(Long id) {
        super("Não achei o cliente com esse id ai que tu passou não: " + id);
    }
}