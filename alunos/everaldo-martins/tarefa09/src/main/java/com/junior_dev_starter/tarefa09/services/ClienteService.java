package com.junior_dev_starter.tarefa09.services;

import com.junior_dev_starter.tarefa09.dtos.ClienteRequestDTO;
import com.junior_dev_starter.tarefa09.dtos.ClienteResponseDTO;
import com.junior_dev_starter.tarefa09.exceptions.ClienteNotFoundException;
import com.junior_dev_starter.tarefa09.models.Cliente;
import com.junior_dev_starter.tarefa09.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteResponseDTO salvar(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();

        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());

        Cliente salvo = clienteRepository.save(cliente);
        return toDTO(salvo);
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
        return clienteRepository.findByNomeLike("%" + prefixo + "%")
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ClienteResponseDTO atualizar(Long id, ClienteRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));

        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());

        Cliente salvo = clienteRepository.save(cliente);
        return toDTO(salvo);
    }

    public void remover(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
        clienteRepository.delete(cliente);
    }

    private ClienteResponseDTO toDTO(Cliente cliente) {
        return new ClienteResponseDTO(cliente.getId(), cliente.getNome(), cliente.getEmail());
    }
}
