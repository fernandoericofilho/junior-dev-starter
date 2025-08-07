package br.com.lucaskevin.tarefa07;

import br.com.lucaskevin.tarefa07.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // 1. Diz ao Spring para gerenciar esta classe
public class TesteCustomRepository implements CommandLineRunner { // 2. Diz que esta classe deve rodar na inicialização

    @Autowired // 3. Pede ao Spring para INJETAR uma instância de ClienteRepository aqui
    private ClienteRepository clienteRepository;

    @Override // 4. Este é o método que será executado automaticamente
    public void run(String... args) throws Exception {
        System.out.println("\n\n--- INICIANDO TESTES DE CONSULTAS CUSTOMIZADAS ---");

        // Teste 1: Buscar clientes contendo "Ana" no nome
        System.out.println("\nBuscando clientes com 'Ana' no nome:");
        List<Cliente> clientesPorNome = clienteRepository.findByNomeContaining("Ana");
        // O Lombok nos dá o método .toString() de graça na classe Cliente!
        clientesPorNome.forEach(cliente -> System.out.println("Encontrado: " + cliente));

        // Teste 2: Buscar cliente pelo email exato
        System.out.println("\nBuscando cliente com email 'carlos.silva@example.com':");
        clienteRepository.findByEmail("carlos.silva@example.com")
                .ifPresent(cliente -> System.out.println("Encontrado: " + cliente));

        // Teste 3: Buscar clientes com telefone CELULAR
        System.out.println("\nBuscando clientes com telefone do tipo 'CELULAR':");
        List<Cliente> clientesPorTipoTelefone = clienteRepository.findByTelefones_Tipo("CELULAR");
        clientesPorTipoTelefone.forEach(cliente -> System.out.println("Encontrado: " + cliente));


        System.out.println("\n--- FIM DOS TESTES DE CONSULTAS CUSTOMIZADAS ---\n\n");
    }
}