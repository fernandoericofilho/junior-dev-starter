package com.junior_dev_starter.tarefa09.controllers;

import com.junior_dev_starter.tarefa09.dtos.ClienteRequestDTO;
import com.junior_dev_starter.tarefa09.dtos.ClienteResponseDTO;
import com.junior_dev_starter.tarefa09.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Lista todos os clientes", description = "Retorna uma lista com todos os clientes cadastrados no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listagem concluída com com sucesso.")
    })
    @GetMapping
    public List<ClienteResponseDTO> listar() {
        return clienteService.listarTodos();
    }

    @Operation(summary = "Busca um cliente pelo ID.", description = "Retorna um cliente pelo ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrato com sucesso."),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado.")
    })
    @GetMapping("/{id}")
    public ClienteResponseDTO buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    @Operation(summary = "Faz a busca por clientes com o termo fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mesmo com um Array vazio.")
    })
    @GetMapping("/prefix/{prefix}")
    public List<ClienteResponseDTO> buscarPorPrefixo(@PathVariable String prefix) {
        return clienteService.buscaPorInicial(prefix);
    }

    @Operation(summary = "Cria um novo cliente", description = "Adiciona um novo cliente no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso.")
    })
    @PostMapping
    public ClienteResponseDTO salvar(@RequestBody ClienteRequestDTO dto) {
        return clienteService.salvar(dto);
    }

    @Operation(summary = "Atualiza um cliente pelo ID", description = "Atualiza um cliente e salva no banco de dados pelo ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado.")
    })
    @PutMapping("/{id}")
    public ClienteResponseDTO atualizar(@PathVariable Long id, @RequestBody ClienteRequestDTO dto) {
        return clienteService.atualizar(id, dto);
    }

    @Operation(summary = "Remove um cliente pelo ID", description = "Remove um cliente pelo ID do banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente removido com sucesso."),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado.")
    })
    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        clienteService.remover(id);
    }
}

