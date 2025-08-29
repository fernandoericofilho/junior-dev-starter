package com.example.springdatajpa.service;

import com.example.springdatajpa.dto.ClienteRequestDTO;
import com.example.springdatajpa.dto.ClienteResponseDTO;
import com.example.springdatajpa.exception.ClienteNotFoundException;
import com.example.springdatajpa.mapper.ClienteMapper;
import com.example.springdatajpa.model.Cliente;
import com.example.springdatajpa.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private static final Logger log = LoggerFactory.getLogger(ClienteService.class);

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public ClienteResponseDTO salvar(ClienteRequestDTO requestDTO) {
        log.info("Iniciando processo de criação de cliente com email: {}", requestDTO.getEmail());
        if (clienteRepository.existsByEmail(requestDTO.getEmail())) {
            log.warn("Tentativa de criar cliente com email duplicado: {}", requestDTO.getEmail());
            throw new IllegalArgumentException("Email já cadastrado: " + requestDTO.getEmail());
        }
        Cliente cliente = clienteMapper.toEntity(requestDTO);
        Cliente clienteSalvo = clienteRepository.save(cliente);
        log.info("Cliente criado com sucesso! id={}, nome={}", clienteSalvo.getId(), clienteSalvo.getNome());
        return clienteMapper.toDTO(clienteSalvo);
    }

    public Page<ClienteResponseDTO> listarTodos(Pageable pageable) {
        log.info("Buscando lista paginada de clientes. Página: {}, Tamanho: {}", pageable.getPageNumber(), pageable.getPageSize());
        Page<Cliente> paginaDeClientes = clienteRepository.findAll(pageable);
        log.info("Encontrados {} clientes na página {}", paginaDeClientes.getNumberOfElements(), pageable.getPageNumber());
        return paginaDeClientes.map(clienteMapper::toDTO);
    }

    public ClienteResponseDTO buscarPorId(Long id) {
        log.info("Iniciando busca por cliente com id: {}", id);
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> {
            log.warn("Cliente com id: {} não encontrado.", id);
            return new ClienteNotFoundException(id);
        });
        log.info("Cliente com id: {} encontrado com sucesso.", id);
        return clienteMapper.toDTO(cliente);
    }

    public List<ClienteResponseDTO> buscaPorInicial(String prefixo) {
        log.info("Iniciando busca por clientes com nome começando com: '{}'", prefixo);
        List<Cliente> clientes = clienteRepository.findByNomeLike(prefixo + "%");
        log.info("Busca por prefixo '{}' encontrou {} clientes.", prefixo, clientes.size());
        return clientes.stream()
                .map(clienteMapper::toDTO)
                .collect(Collectors.toList());
    }

}