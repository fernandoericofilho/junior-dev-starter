package com.junior_dev_starter.tarefa09.repositories;

import com.junior_dev_starter.tarefa09.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNomeLike(String prefix);
}
