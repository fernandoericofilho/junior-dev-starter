package com.example.springdatajpa.service;

import com.example.springdatajpa.dto.ClienteRequestDTO;
import com.example.springdatajpa.dto.ClienteResponseDTO;
import com.example.springdatajpa.exception.ClienteNotFoundException;
import com.example.springdatajpa.model.Cliente;
import com.example.springdatajpa.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteResponseDTO salvar(ClienteRequestDTO requestDTO) {
        Cliente cliente = new Cliente();
        cliente.setNome(requestDTO.getNome());
        cliente.setEmail(requestDTO.getEmail());
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return toDTO(clienteSalvo);
    }

    public List<ClienteResponseDTO> listarTodos() {
        return clienteRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ClienteResponseDTO buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
        return toDTO(cliente);
    }

    public List<ClienteResponseDTO> buscaPorInicial(String prefixo) {
        List<Cliente> clientes = clienteRepository.findByNomeLike(prefixo + "%");
        return clientes.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private ClienteResponseDTO toDTO(Cliente cliente) {
        return new ClienteResponseDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail()
        );
    }
}