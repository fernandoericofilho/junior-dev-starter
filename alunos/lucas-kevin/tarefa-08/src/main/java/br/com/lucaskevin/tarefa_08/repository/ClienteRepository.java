package br.com.lucaskevin.tarefa_08.repository;

import br.com.lucaskevin.tarefa_08.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}