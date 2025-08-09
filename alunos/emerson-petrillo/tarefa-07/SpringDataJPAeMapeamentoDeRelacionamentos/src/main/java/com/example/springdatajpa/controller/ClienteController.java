package com.example.springdatajpa.controller;

import com.example.springdatajpa.dto.ClienteRequestDTO;
import com.example.springdatajpa.dto.ClienteResponseDTO;
import com.example.springdatajpa.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Operation(summary = "Cria um novo cliente", description = "Recebe os dados de um novo cliente, salva no banco de dados e retorna o cliente recém-criado com seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de requisição inválidos")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponseDTO salvar(@RequestBody ClienteRequestDTO dto) {
        return clienteService.salvar(dto);
    }

    @Operation(summary = "Lista todos os clientes cadastrados", description = "Retorna uma lista com todos os clientes presentes no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de clientes retornada com sucesso")
    })
    @GetMapping
    public List<ClienteResponseDTO> listar() {
        return clienteService.listarTodos();
    }

    @Operation(summary = "Busca um cliente por seu ID", description = "Retorna os detalhes de um único cliente com base no ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado para o ID fornecido")
    })
    @GetMapping("/{id}")
    public ClienteResponseDTO buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    @Operation(summary = "Busca clientes por prefixo do nome", description = "Retorna uma lista de clientes cujos nomes começam com o prefixo especificado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca por prefixo concluída com sucesso (pode retornar uma lista vazia)")
    })
    @GetMapping("/prefix/{prefix}")
    public List<ClienteResponseDTO> buscarPorPrefixo(@PathVariable String prefix) {
        return clienteService.buscaPorInicial(prefix);
    }
}