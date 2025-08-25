package com.junior_dev_starter.tarefa10.models;

import com.junior_dev_starter.tarefa10.enums.TelefoneTipo;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    private TelefoneTipo tipo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
