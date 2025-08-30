package br.com.lucaskevin.tarefa_09.service;

import br.com.lucaskevin.tarefa_09.dto.ClienteRequestDTO;
import br.com.lucaskevin.tarefa_09.dto.ClienteResponseDTO;
import br.com.lucaskevin.tarefa_09.exception.ClienteNotFoundException;
import br.com.lucaskevin.tarefa_09.mapper.ClienteMapper;
import br.com.lucaskevin.tarefa_09.model.Cliente;
import br.com.lucaskevin.tarefa_09.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {


    private static final Logger log = LoggerFactory.getLogger(ClienteService.class);

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public ClienteResponseDTO salvar(ClienteRequestDTO dto) {
        log.info("Iniciando processo de criação de cliente com email={}", dto.getEmail());

        if (clienteRepository.existsByEmail(dto.getEmail())) {
            log.warn("Tentativa de criar cliente com email duplicado: {}", dto.getEmail());
            throw new IllegalArgumentException("Email já cadastrado: " + dto.getEmail());
        }

        Cliente cliente = clienteMapper.toEntity(dto);
        Cliente clienteSalvo = clienteRepository.save(cliente);

        log.info("Cliente criado com sucesso! id={}, nome={}", clienteSalvo.getId(), clienteSalvo.getNome());
        return clienteMapper.toDTO(clienteSalvo);
    }

    public Page<ClienteResponseDTO> listarTodos(Pageable pageable) {
        log.info("Buscando lista de clientes paginada. Página={}, Tamanho={}, Ordenação={}",
                pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());

        Page<Cliente> clientesPage = clienteRepository.findAll(pageable);
        Page<ClienteResponseDTO> dtoPage = clientesPage.map(clienteMapper::toDTO);

        log.info("Busca paginada concluída. Retornando {} clientes nesta página.", dtoPage.getNumberOfElements());
        return dtoPage;
    }

    public ClienteResponseDTO buscarPorId(Long id) {
        log.info("Iniciando busca por cliente com id={}", id);

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Cliente com id={} não encontrado.", id);
                    return new ClienteNotFoundException(id);
                });

        log.info("Cliente com id={} encontrado com sucesso.", id);
        return clienteMapper.toDTO(cliente);
    }
}