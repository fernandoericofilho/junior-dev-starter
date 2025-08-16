package br.com.lucaskevin.tarefa_09.service;

import br.com.lucaskevin.tarefa_09.dto.ClienteRequestDTO;
import br.com.lucaskevin.tarefa_09.dto.ClienteResponseDTO;
import br.com.lucaskevin.tarefa_09.model.Cliente;
import br.com.lucaskevin.tarefa_09.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import br.com.lucaskevin.tarefa_09.exception.ClienteNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    // Injeção de Dependência via construtor
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteResponseDTO salvar(ClienteRequestDTO dto) {
        // Converte o DTO de requisição para uma entidade Cliente
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());

        // Salva a entidade no banco
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