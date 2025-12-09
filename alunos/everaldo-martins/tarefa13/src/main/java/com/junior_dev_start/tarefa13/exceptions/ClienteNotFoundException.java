package com.junior_dev_start.tarefa13.exceptions;

public class ClienteNotFoundException extends RuntimeException {
    public ClienteNotFoundException(Long id) {
        super("Cliente com id: " + id + " não encontrado." );
    }
}

