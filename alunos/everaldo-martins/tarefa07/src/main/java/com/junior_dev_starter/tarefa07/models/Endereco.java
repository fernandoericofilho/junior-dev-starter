package com.junior_dev_starter.tarefa07.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;
    private String cidade;
    private String estado;

    @OneToOne
    @JoinColumn(name = "cliente_id", unique = true)
    private Cliente cliente;
}

