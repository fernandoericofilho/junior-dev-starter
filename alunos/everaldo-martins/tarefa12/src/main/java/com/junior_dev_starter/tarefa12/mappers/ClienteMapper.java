package com.junior_dev_starter.tarefa12.mappers;

import com.junior_dev_starter.tarefa12.dtos.ClienteRequestDTO;
import com.junior_dev_starter.tarefa12.dtos.ClienteResponseDTO;
import com.junior_dev_starter.tarefa12.models.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        return cliente;
    }

    public void updateEntity(ClienteRequestDTO dto, Cliente cliente){
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
    }

    public ClienteResponseDTO toDTO(Cliente cliente) {
        return new ClienteResponseDTO(cliente.getId(), cliente.getNome(), cliente.getEmail());
    }
}
