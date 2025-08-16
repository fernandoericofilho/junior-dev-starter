package br.com.lucaskevin.tarefa_09.exception;

public class ClienteNotFoundException extends RuntimeException {
    public ClienteNotFoundException(Long id) {
        // A mensagem que será enviada na resposta da API
        super("Cliente não encontrado com id: " + id);
    }
}