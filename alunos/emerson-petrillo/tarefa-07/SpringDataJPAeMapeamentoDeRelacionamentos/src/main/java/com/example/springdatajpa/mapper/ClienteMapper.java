package com.example.springdatajpa.mapper;

import com.example.springdatajpa.dto.ClienteRequestDTO;
import com.example.springdatajpa.dto.ClienteResponseDTO;
import com.example.springdatajpa.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        return cliente;
    }

    public ClienteResponseDTO toDTO(Cliente cliente) {
        return new ClienteResponseDTO(cliente.getId(), cliente.getNome(), cliente.getEmail());
    }

}
