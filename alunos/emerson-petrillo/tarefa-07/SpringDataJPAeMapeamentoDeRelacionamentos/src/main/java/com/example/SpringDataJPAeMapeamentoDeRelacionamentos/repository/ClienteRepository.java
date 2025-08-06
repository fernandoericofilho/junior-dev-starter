package com.example.SpringDataJPAeMapeamentoDeRelacionamentos.repository;

import com.example.SpringDataJPAeMapeamentoDeRelacionamentos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    /**
     * Encontra clientes cujo nome contém a string fornecida (case-sensitive).
     * Exemplo de JPQL gerado: "select c from Cliente c where c.nome like %?1%"
     * @param nome A string a ser procurada no nome dos clientes.
     * @return Uma lista de clientes que correspondem ao critério.
     */
    List<Cliente> findByNomeContaining(String nome);

    /**
     * Encontra um cliente pelo seu endereço de e-mail exato.
     * Como o email é único, esperamos no máximo um resultado. Usar Optional é uma boa prática
     * para evitar NullPointerExceptions se nenhum cliente for encontrado.
     * @param email O e-mail exato a ser procurado.
     * @return Um Optional contendo o cliente, se encontrado, ou um Optional vazio.
     */
    Optional<Cliente> findByEmail(String email);

    /**
     * Encontra todos os clientes que possuem um telefone de um determinado tipo.
     * O Spring Data JPA cria a junção (JOIN) entre Cliente e Telefone automaticamente.
     * @param tipo O tipo de telefone a ser buscado (ex: "CELULAR", "FIXO").
     * @return Uma lista de clientes que possuem um telefone com o tipo especificado.
     */
    List<Cliente> findByTelefones_Tipo(String tipo);
}