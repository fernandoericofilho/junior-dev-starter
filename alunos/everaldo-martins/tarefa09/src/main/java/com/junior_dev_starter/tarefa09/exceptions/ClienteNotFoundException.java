package com.junior_dev_starter.tarefa09.exceptions;

public class ClienteNotFoundException extends RuntimeException {
    public ClienteNotFoundException(Long id) {
        super("Cliente com id: " + id + " não encontrado." );
    }
}

