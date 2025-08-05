package com.example.SpringDataJPAeMapeamentoDeRelacionamentos.controller;

import com.example.SpringDataJPAeMapeamentoDeRelacionamentos.model.Cliente;
import com.example.SpringDataJPAeMapeamentoDeRelacionamentos.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    /**
     * Endpoint para listar todos os clientes.
     * Mapeado para: GET http://localhost:8080/clientes
     * @return Uma lista de todos os clientes em formato JSON.
     */
    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listarTodos();
    }

    /**
     * Endpoint para buscar um único cliente pelo seu ID.
     * Mapeado para: GET http://localhost:8080/clientes/{id} (ex: /clientes/1)
     * @param id O ID vindo da URL, capturado pela anotação @PathVariable.
     * @return O cliente encontrado, ou uma resposta de erro se não existir.
     */
    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    /**
     * Endpoint para criar um novo cliente.
     * Mapeado para: POST http://localhost:8080/clientes
     * @param cliente O objeto Cliente, criado a partir do JSON enviado no corpo da requisição (@RequestBody).
     * @return O cliente recém-salvo, com seu ID preenchido.
     */
    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) {
        return clienteService.salvar(cliente);
    }
}