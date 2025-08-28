package com.example.springdatajpa.repository;

import com.example.springdatajpa.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNomeLike(String nome);
    boolean existsByEmail(String email);

}