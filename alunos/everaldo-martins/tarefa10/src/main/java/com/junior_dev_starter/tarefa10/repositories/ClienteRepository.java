package com.junior_dev_starter.tarefa10.repositories;

import com.junior_dev_starter.tarefa10.models.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Page<Cliente> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
    List<Cliente> findByNomeContainingIgnoreCase(String nome);
    Optional<Cliente> findByEmail(String email);
    boolean existsByEmail(String email);
}
