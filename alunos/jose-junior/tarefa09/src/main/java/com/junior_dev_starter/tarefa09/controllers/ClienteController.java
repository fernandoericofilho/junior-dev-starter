package com.junior_dev_starter.tarefa09.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junior_dev_starter.tarefa09.dtos.ClienteRequestDTO;
import com.junior_dev_starter.tarefa09.dtos.ClienteResponseDTO;
import com.junior_dev_starter.tarefa09.repositories.ClienteRepository;
import com.junior_dev_starter.tarefa09.services.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService, ClienteRepository clienteRepository) {
        this.clienteService = clienteService;
    }

    @Operation(summary = "Lista todos os clientes cadastrados", description = "Retorna uma lista com todos os clientes cadastrados", method = "GET")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de clientes cadastrados encontrada!")
    })
    @GetMapping
    public List<ClienteResponseDTO> listarClientes() {
        return clienteService.listarTodosClientes();
    }
    
    @Operation(summary = "Busca um cliente cadastrado pelo ID", description = "Retorna os dados de um cliente, de acordo com o ID fornecido", method = "GET")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente encontrado com sucesso!"),
        @ApiResponse(responseCode = "404", description = "Cliente do ID fornecido não encontrado!")
    })
    @GetMapping("/{id}")
    public ClienteResponseDTO buscarClientePorId(@PathVariable Long id) {
        return clienteService.buscarClientePorId(id);
    }
    
    @Operation(summary = "Busca um ou mais clientes cadastrados, de acordo com um prefixo para o seu nome", description = "Retorna uma lista de clientes que começam o nome com o prefixo informado", method = "GET")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente(s) encontrado(s) com sucesso! (ou apresenta uma lista vazia)")
    })
    @GetMapping("/prefixo/{prefixo}")
    public List<ClienteResponseDTO> buscarClientePorInicial(@PathVariable String prefixo) {
        return clienteService.buscarClientePorInicial(prefixo);
    }

    @Operation(summary = "Cadastra um novo cliente", description = "Recebe os dados de um novo cliente, salva no banco de dados e o retorna com o seu ID", method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cliente cadastrado com sucesso!"),
        @ApiResponse(responseCode = "400", description = "Requisição inválida!")
    })
    @PostMapping()
    public ClienteResponseDTO cadastrarCliente(@RequestBody ClienteRequestDTO clienteDto) {
        return clienteService.cadastrarCliente(clienteDto);
    }
}