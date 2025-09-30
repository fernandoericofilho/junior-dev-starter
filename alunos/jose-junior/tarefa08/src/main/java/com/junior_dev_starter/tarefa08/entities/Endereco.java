package com.junior_dev_starter.tarefa08.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String cidade;
    private String estado;
    private String cep;

    @OneToOne
    @JoinColumn(name = "cliente_id", unique = true)
    @JsonBackReference
    private Cliente cliente;

    public Endereco() {

    }

    public Endereco(Long id, String logradouro, String cidade, String estado, String cep) {
        this.id = id;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
}