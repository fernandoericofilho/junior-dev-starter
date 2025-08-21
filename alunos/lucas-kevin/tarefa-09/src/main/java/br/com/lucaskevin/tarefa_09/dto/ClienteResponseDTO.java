package br.com.lucaskevin.tarefa_09.dto;

public class ClienteResponseDTO {
    private Long id;
    private String nome;
    private String email;

    // Construtor
    public ClienteResponseDTO(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
}