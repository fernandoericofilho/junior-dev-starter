package com.junior_dev_starter.tarefa12.services;

import com.junior_dev_starter.tarefa12.dtos.ClienteRequestDTO;
import com.junior_dev_starter.tarefa12.dtos.ClienteResponseDTO;
import com.junior_dev_starter.tarefa12.exceptions.ClienteNotFoundException;
import com.junior_dev_starter.tarefa12.mappers.ClienteMapper;
import com.junior_dev_starter.tarefa12.models.Cliente;
import com.junior_dev_starter.tarefa12.repositories.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ClienteService {

    @Autowired
    private final ClienteRepository clienteRepository;
    @Autowired
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public ClienteResponseDTO salvar(ClienteRequestDTO dto) {
        log.info("Criando cliente com email={}", dto.getEmail());

        if (clienteRepository.existsByEmail(dto.getEmail())) {
            log.warn("Tentativa de criar cliente duplicado com email={}", dto.getEmail());
            throw new IllegalArgumentException("Email já cadastrado: " + dto.getEmail());
        }

        Cliente cliente = clienteMapper.toEntity(dto);
        Cliente salvo = clienteRepository.save(cliente);

        log.info("Cliente criado com sucesso id={} nome={} email={}",
                salvo.getId(), salvo.getNome(), salvo.getEmail());
        return clienteMapper.toDTO(salvo);
    }

    public Page<ClienteResponseDTO> listarTodos(Pageable pageable) {
        log.info("Listando clientes - page={} size={} sort={}",
                pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());
        Page<ClienteResponseDTO> pageDTO = clienteRepository.findAll(pageable)
                .map(clienteMapper::toDTO);
        log.info("Total de clientes retornados nesta página={}", pageDTO.getNumberOfElements());
        return pageDTO;
    }

    public ClienteResponseDTO buscarPorId(Long id) {
        log.info("Buscando cliente por id={}", id);
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Cliente não encontrado id={}", id);
                    return new ClienteNotFoundException(id);
                });
        log.info("Cliente encontrado id={} nome={} email={}",
                cliente.getId(), cliente.getNome(), cliente.getEmail());
        return clienteMapper.toDTO(cliente);
    }

    public Page<ClienteResponseDTO> buscarClientesPorNomePaginado(String nome, Pageable pageable) {
        log.info("Buscando clientes por nome={} com paginação", nome);

        if (nome == null || nome.trim().isEmpty()) {
            log.warn("Nome de busca não fornecido ou vazio.");
            return Page.empty(pageable);
        }

        Page<ClienteResponseDTO> pageDTO = clienteRepository.findByNomeContainingIgnoreCase(nome, pageable)
                .map(clienteMapper::toDTO);
        log.info("Total de clientes retornados nesta busca={}", pageDTO.getNumberOfElements());
        if (pageDTO.isEmpty()) {
            log.info("Nenhum cliente encontrado para o nome={}", nome);
        }

        return pageDTO;
    }

    public ClienteResponseDTO atualizar(Long id, ClienteRequestDTO dto) {
        log.info("Atualizando cliente com email={}", dto.getEmail());

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Cliente com id={} não encontrado.", id);
                    return new ClienteNotFoundException(id);
                });

        if (clienteRepository.existsByEmail(dto.getEmail())) {
            log.warn("Tentativa de atualizar cliente com email duplicado={}", dto.getEmail());
            throw new IllegalArgumentException("Email já cadastrado: " + dto.getEmail());
        }

        clienteMapper.updateEntity(dto, cliente);

        Cliente atualizado = clienteRepository.save(cliente);

        log.info("Cliente atualizado com sucesso id={} nome={} email={}",
                atualizado.getId(), atualizado.getNome(), atualizado.getEmail());
        return clienteMapper.toDTO(atualizado);
    }

    public ClienteResponseDTO remover(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
        clienteRepository.delete(cliente);
        return clienteMapper.toDTO(cliente);
    }
}
