package br.com.lucaskevin.tarefa_09.controller;

import br.com.lucaskevin.tarefa_09.dto.ClienteRequestDTO;
import br.com.lucaskevin.tarefa_09.dto.ClienteResponseDTO;
import br.com.lucaskevin.tarefa_09.service.ClienteService;
// Imports do Swagger/OpenAPI
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@Tag(name = "Cliente API", description = "API para gerenciamento de clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Operation(
            summary = "Salva um novo cliente",
            description = "Cria um novo cliente no banco de dados"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClienteResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados de requisição inválidos",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<ClienteResponseDTO> salvar(
            @RequestBody(
                    description = "Dados do cliente a ser criado",
                    required = true,
                    content = @Content(schema = @Schema(implementation = ClienteRequestDTO.class))
            )
            @org.springframework.web.bind.annotation.RequestBody ClienteRequestDTO dto
    ) {
        ClienteResponseDTO clienteSalvo = clienteService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @Operation(summary = "Lista todos os clientes", description = "Retorna uma lista com todos os clientes cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ClienteResponseDTO.class)))
    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listar() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @Operation(summary = "Busca um cliente por ID", description = "Retorna os dados de um cliente específico a partir do seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClienteResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado para o ID informado",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> buscarPorId(
            @Parameter(description = "ID do cliente a ser buscado", required = true, example = "1")
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @Operation(summary = "Busca clientes por prefixo do nome", description = "Retorna uma lista de clientes cujo nome começa com o prefixo informado")
    @ApiResponse(responseCode = "200", description = "Clientes encontrados",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ClienteResponseDTO.class)))
    @GetMapping("/prefix/{prefixo}")
    public ResponseEntity<List<ClienteResponseDTO>> buscarPorPrefixo(
            @Parameter(description = "Prefixo do nome para busca", example = "Lu")
            @PathVariable String prefixo
    ) {
        return ResponseEntity.ok(clienteService.buscaPorInicial(prefixo));
    }
}
