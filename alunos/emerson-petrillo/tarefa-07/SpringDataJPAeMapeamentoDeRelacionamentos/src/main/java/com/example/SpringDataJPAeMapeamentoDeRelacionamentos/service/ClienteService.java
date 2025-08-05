package com.example.SpringDataJPAeMapeamentoDeRelacionamentos.service;

import com.example.SpringDataJPAeMapeamentoDeRelacionamentos.model.Cliente;
import com.example.SpringDataJPAeMapeamentoDeRelacionamentos.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * Lógica para listar todos os clientes.
     * Neste caso, apenas repassa a chamada para o repositório.
     * @return uma lista de todos os clientes.
     */
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    /**
     * Lógica para buscar um cliente por seu ID.
     * @param id O ID do cliente a ser buscado.
     * @return O Cliente, se encontrado.
     * @throws RuntimeException se o cliente não for encontrado.
     */
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com id: " + id));
    }

    /**
     * Lógica para salvar um novo cliente ou atualizar um existente.
     * @param cliente O objeto cliente a ser salvo.
     * @return O cliente salvo (geralmente com o ID preenchido).
     */
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}