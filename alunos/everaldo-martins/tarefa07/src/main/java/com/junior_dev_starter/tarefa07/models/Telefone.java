package com.junior_dev_starter.tarefa07.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
