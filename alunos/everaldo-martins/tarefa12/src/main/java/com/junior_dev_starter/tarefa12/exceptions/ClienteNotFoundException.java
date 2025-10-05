package com.junior_dev_starter.tarefa12.exceptions;

public class ClienteNotFoundException extends RuntimeException {
    public ClienteNotFoundException(Long id) {
        super("Cliente com id: " + id + " não encontrado." );
    }
}

