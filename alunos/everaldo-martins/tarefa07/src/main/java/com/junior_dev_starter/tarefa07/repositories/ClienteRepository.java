package com.junior_dev_starter.tarefa07.repositories;

import com.junior_dev_starter.tarefa07.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNomeContaining(String nome);
    Optional<Cliente> findByEmail(String email);
    List<Cliente> findByTelefonesTipo(String tipo);
}
