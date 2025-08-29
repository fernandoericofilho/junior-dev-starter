package com.junior_dev_starter.tarefa10.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class ClienteResponseDTO extends RepresentationModel<ClienteResponseDTO> {
    private Long id;
    private String nome;
    private String email;
}
