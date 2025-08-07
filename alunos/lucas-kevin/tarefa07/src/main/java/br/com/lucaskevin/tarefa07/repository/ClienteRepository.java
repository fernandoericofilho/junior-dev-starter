package br.com.lucaskevin.tarefa07.repository;

import br.com.lucaskevin.tarefa07.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;     // Import necessário
import java.util.Optional; // Import necessário

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Adicione estes 3 métodos:

    // 1. Encontra clientes cujo nome contenha o texto fornecido (busca parcial)
    List<Cliente> findByNomeContaining(String nome);

    // 2. Encontra um cliente pelo email exato (retorna um Optional para evitar erros de nulo)
    Optional<Cliente> findByEmail(String email);

    // 3. Encontra clientes que possuam um telefone de um determinado tipo (ex: "CELULAR")
    List<Cliente> findByTelefones_Tipo(String tipo);

}