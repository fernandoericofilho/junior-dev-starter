package com.junior_dev_starter.tarefa09.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.junior_dev_starter.tarefa09.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNomeContaining(String nome);
    Optional<Cliente> findByEmail(String email);
    List<Cliente> findByTelefones_Tipo(String tipo);
    List<Cliente> findByNomeLike(String prefixo);
}