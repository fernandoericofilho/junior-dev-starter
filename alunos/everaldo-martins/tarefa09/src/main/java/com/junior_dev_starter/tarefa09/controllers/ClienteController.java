package com.junior_dev_starter.tarefa09.controllers;

import com.junior_dev_starter.tarefa09.dtos.ClienteRequestDTO;
import com.junior_dev_starter.tarefa09.dtos.ClienteResponseDTO;
import com.junior_dev_starter.tarefa09.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<ClienteResponseDTO> listar() {
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public ClienteResponseDTO buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    @GetMapping("/prefix/{prefix}")
    public List<ClienteResponseDTO> buscarPorPrefixo(@PathVariable String prefix) {
        return clienteService.buscaPorInicial(prefix);
    }

    @PostMapping
    public ClienteResponseDTO salvar(@RequestBody ClienteRequestDTO dto) {
        return clienteService.salvar(dto);
    }

    @PutMapping("/{id}")
    public ClienteResponseDTO atualizar(@PathVariable Long id, @RequestBody ClienteRequestDTO dto) {
        return clienteService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        clienteService.excluir(id);
    }
}

