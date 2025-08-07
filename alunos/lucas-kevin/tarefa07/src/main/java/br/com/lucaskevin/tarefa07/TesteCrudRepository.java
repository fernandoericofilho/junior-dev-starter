package br.com.lucaskevin.tarefa07;

import br.com.lucaskevin.tarefa07.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TesteCrudRepository implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n\n--- INICIANDO TESTES DE CRUD ---");

        // --- CREATE (Criar) ---
        System.out.println("\n1. CRIANDO um novo cliente...");
        Cliente novoCliente = new Cliente();
        novoCliente.setNome("Mariana Oliveira");
        novoCliente.setEmail("mariana.oliveira@example.com");
        Cliente clienteSalvo = clienteRepository.save(novoCliente); // O método save() retorna a entidade salva com o ID preenchido
        System.out.println("Cliente salvo com sucesso! ID: " + clienteSalvo.getId());


        // --- READ (Ler) ---
        System.out.println("\n2. LENDO o cliente com ID " + clienteSalvo.getId() + "...");
        Optional<Cliente> clienteBuscado = clienteRepository.findById(clienteSalvo.getId());
        clienteBuscado.ifPresent(c -> System.out.println("Cliente encontrado: " + c));


        // --- UPDATE (Atualizar) ---
        System.out.println("\n3. ATUALIZANDO o email do cliente com ID " + clienteSalvo.getId() + "...");
        if (clienteBuscado.isPresent()) {
            Cliente clienteParaAtualizar = clienteBuscado.get();
            clienteParaAtualizar.setEmail("mariana.o.silva@example.com");
            clienteRepository.save(clienteParaAtualizar); // O mesmo método save() serve para atualizar
            System.out.println("Cliente atualizado: " + clienteParaAtualizar);
        }

        // --- DELETE (Apagar) ---
        System.out.println("\n4. APAGANDO o cliente com ID " + clienteSalvo.getId() + "...");
        clienteRepository.deleteById(clienteSalvo.getId());
        System.out.println("Cliente apagado.");

        // Verificação final
        System.out.println("\n5. VERIFICANDO se o cliente com ID " + clienteSalvo.getId() + " ainda existe...");
        Optional<Cliente> clienteApagado = clienteRepository.findById(clienteSalvo.getId());
        if (clienteApagado.isPresent()) {
            System.out.println("Erro: Cliente ainda foi encontrado.");
        } else {
            System.out.println("Sucesso: Cliente não foi encontrado, como esperado.");
        }

        System.out.println("\n--- FIM DOS TESTES DE CRUD ---\n\n");
    }
}