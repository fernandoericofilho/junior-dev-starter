//package com.example.SpringDataJPAeMapeamentoDeRelacionamentos;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class SpringDataJpAeMapeamentoDeRelacionamentosApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SpringDataJpAeMapeamentoDeRelacionamentosApplication.class, args);
//	}
//
//}

package com.example.SpringDataJPAeMapeamentoDeRelacionamentos;

import com.example.SpringDataJPAeMapeamentoDeRelacionamentos.model.Cliente;
import com.example.SpringDataJPAeMapeamentoDeRelacionamentos.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringDataJpAeMapeamentoDeRelacionamentosApplication implements CommandLineRunner {

	// Logger para imprimir mensagens no console de forma mais profissional
	private static final Logger log = LoggerFactory.getLogger(SpringDataJpAeMapeamentoDeRelacionamentosApplication.class);

	// Injetando o repositório de clientes. O Spring nos dará uma implementação pronta.
	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpAeMapeamentoDeRelacionamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info(">>>> INICIANDO TESTES DO REPOSITÓRIO <<<<");

		// Chamando os métodos de teste
		testarCrudJpaRepository();
		testarMetodosCustomizados();

		log.info(">>>> TESTES FINALIZADOS COM SUCESSO <<<<");
	}

	private void testarCrudJpaRepository() {
		log.info("--> Iniciando Testes CRUD (herdados do JpaRepository)...");

		// 1. CREATE (Salvar um novo cliente)
		log.info("1. Testando SAVE (CREATE)...");
		Cliente novoCliente = new Cliente("Beatriz Costa", "beatriz.costa@example.com");
		clienteRepository.save(novoCliente);
		log.info("Cliente 'Beatriz Costa' salvo com ID: {}", novoCliente.getId());

		// 2. READ (Buscar todos e buscar por ID)
		log.info("\n2. Testando FIND (READ)...");
		List<Cliente> todosOsClientes = clienteRepository.findAll();
		log.info("Todos os clientes no banco ({}):", todosOsClientes.size());
		todosOsClientes.forEach(cliente -> log.info(" - {}", cliente.toString()));

		Optional<Cliente> clienteBuscado = clienteRepository.findById(novoCliente.getId());
		log.info("Buscando cliente pelo ID {}: {}", novoCliente.getId(), clienteBuscado.orElse(null));

		// 3. DELETE (Remover o cliente que criamos)
		log.info("\n3. Testando DELETE...");
		clienteRepository.deleteById(novoCliente.getId());
		log.info("Cliente com ID {} deletado.", novoCliente.getId());

		Optional<Cliente> clienteDeletado = clienteRepository.findById(novoCliente.getId());
		log.info("Verificando se o cliente foi deletado: {}", clienteDeletado.isEmpty() ? "Sim, foi deletado." : "Não, ainda existe.");
		log.info("-------------------------------------------------");
	}

	private void testarMetodosCustomizados() {
		log.info("--> Iniciando Testes dos Métodos Customizados...");

		// Dados iniciais (inseridos pelo Flyway):
		// 1, 'Ana Paula', 'ana.paula@example.com'
		// 2, 'Carlos Silva', 'carlos.silva@example.com'

		// 1. Teste do findByNomeContaining
		log.info("\n1. Testando findByNomeContaining('Carlos')...");
		List<Cliente> clientesPorNome = clienteRepository.findByNomeContaining("Carlos");
		log.info("Resultado:");
		clientesPorNome.forEach(c -> log.info(" - {}", c));

		// 2. Teste do findByEmail
		log.info("\n2. Testando findByEmail('ana.paula@example.com')...");
		Optional<Cliente> clientePorEmail = clienteRepository.findByEmail("ana.paula@example.com");
		log.info("Resultado: {}", clientePorEmail.orElse(null));

		// 3. Teste do findByTelefones_Tipo
		log.info("\n3. Testando findByTelefones_Tipo('CELULAR')...");
		List<Cliente> clientesPorTipoTelefone = clienteRepository.findByTelefones_Tipo("CELULAR");
		log.info("Resultado (clientes com celular):");
		clientesPorTipoTelefone.forEach(c -> log.info(" - {}", c));
		log.info("-------------------------------------------------");
	}
}