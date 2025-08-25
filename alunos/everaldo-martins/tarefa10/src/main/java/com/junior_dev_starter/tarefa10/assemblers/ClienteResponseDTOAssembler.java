package com.junior_dev_starter.tarefa10.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.junior_dev_starter.tarefa10.controllers.ClienteController;
import com.junior_dev_starter.tarefa10.dtos.ClienteRequestDTO;
import com.junior_dev_starter.tarefa10.dtos.ClienteResponseDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class ClienteResponseDTOAssembler implements RepresentationModelAssembler<ClienteResponseDTO, ClienteResponseDTO> {

    @Override
    public @NonNull ClienteResponseDTO toModel(@NonNull ClienteResponseDTO entity) {
        entity.add(linkTo(methodOn(ClienteController.class).buscarPorId(entity.getId())).withSelfRel());
        entity.add(linkTo(methodOn(ClienteController.class).atualizar(entity.getId(), new ClienteRequestDTO())).withRel("update"));
        entity.add(linkTo(methodOn(ClienteController.class).remover(entity.getId())).withRel("delete"));
        entity.add(linkTo(methodOn(ClienteController.class).listar(PageRequest.of(0, 1))).withRel("all"));

        return entity;
    }
}
