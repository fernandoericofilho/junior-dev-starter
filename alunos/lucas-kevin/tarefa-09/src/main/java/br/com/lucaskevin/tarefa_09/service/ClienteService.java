package br.com.lucaskevin.tarefa_09.service;

import br.com.lucaskevin.tarefa_09.dto.ClienteRequestDTO;
import br.com.lucaskevin.tarefa_09.dto.ClienteResponseDTO;
import br.com.lucaskevin.tarefa_09.model.Cliente;
import br.com.lucaskevin.tarefa_09.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public ClienteResponseDTO salvar(ClienteRequestDTO dto) {
        // Converte o DTO de requisição para uma entidade Cliente
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());

        // Salva a entidade no banco
        if (clienteRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado: " + dto.getEmail());
        }

        Cliente cliente = clienteMapper.toEntity(dto);
        Cliente clienteSalvo = clienteRepository.save(cliente);

        // Converte a entidade salva para um DTO de resposta e retorna
        return toDTO(clienteSalvo);
    }

    public List<ClienteResponseDTO> listarTodos() {
        // Busca todos os clientes do banco
        return clienteRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    public Page<ClienteResponseDTO> listarTodos(Pageable pageable) {
                pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());

        Page<Cliente> clientesPage = clienteRepository.findAll(pageable);
        Page<ClienteResponseDTO> dtoPage = clientesPage.map(clienteMapper::toDTO);

        return dtoPage;
    }

    public ClienteResponseDTO buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
        return toDTO(cliente);
    }

    public List<ClienteResponseDTO> buscaPorInicial(String prefixo) {
        return clienteRepository.findByNomeLike(prefixo + "%") // Adiciona o '%' para buscar nomes que começam com o prefixo
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Método privado auxiliar para converter Entidade -> DTO
    private ClienteResponseDTO toDTO(Cliente cliente) {
        return new ClienteResponseDTO(cliente.getId(), cliente.getNome(), cliente.getEmail());
    }
}