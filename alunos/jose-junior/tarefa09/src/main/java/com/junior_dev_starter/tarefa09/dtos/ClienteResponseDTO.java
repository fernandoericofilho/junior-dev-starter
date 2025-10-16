package com.junior_dev_starter.tarefa09.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class ClienteResponseDTO {
    private Long id;
    private String nome;
    private String email;

    public ClienteResponseDTO() {

    }
}
