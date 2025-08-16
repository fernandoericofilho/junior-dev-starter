package br.com.lucaskevin.tarefa_09.repository;

import br.com.lucaskevin.tarefa_09.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    List<Cliente> findByNomeLike(String prefix);

}