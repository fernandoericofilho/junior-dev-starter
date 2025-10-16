package com.junior_dev_starter.tarefa09.exceptions;

public class ClienteNotFoundException extends RuntimeException {
    
    public ClienteNotFoundException(Long id) {
        super("Cliente do ID: " + id + " não encontrado!");
    }    
}
