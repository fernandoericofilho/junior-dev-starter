package br.com.lucaskevin.tarefa_08.service;

import br.com.lucaskevin.tarefa_08.model.Cliente;
import br.com.lucaskevin.tarefa_08.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 1. Marca esta classe como um componente de serviço gerenciado pelo Spring.
public class ClienteService {

    // 2. O service terá uma dependência do repository para poder acessar o banco.
    private final ClienteRepository clienteRepository;

    // 3. Injeção de Dependência via Construtor (a melhor prática!)
    // Em vez de a classe criar seu próprio repository, ela o RECEBE como um parâmetro.
    // O Spring automaticamente nos "dará" a instância do ClienteRepository aqui.
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // --- MÉTODOS DE NEGÓCIO ---

    public List<Cliente> listarTodos() {
        // Delega a chamada para o método findAll() que herdamos do JpaRepository.
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        // O método findById() retorna um Optional.
        // Aqui, usamos .orElseThrow() para retornar o Cliente se ele existir,
        // ou lançar uma exceção se não for encontrado.
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com id: " + id));
    }

    public Cliente salvar(Cliente cliente) {
        // Aqui poderíamos adicionar regras de negócio, como validar o email, etc.
        // Por enquanto, apenas delegamos para o repository.
        return clienteRepository.save(cliente);
    }
}