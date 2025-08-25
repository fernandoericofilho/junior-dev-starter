package com.junior_dev_starter.tarefa10.exceptions;

public class ClienteNotFoundException extends RuntimeException {
    public ClienteNotFoundException(Long id) {
        super("Cliente com id: " + id + " não encontrado." );
    }
}

