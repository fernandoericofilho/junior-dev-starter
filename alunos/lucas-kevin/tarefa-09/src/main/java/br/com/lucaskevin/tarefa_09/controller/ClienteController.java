package br.com.lucaskevin.tarefa_09.controller;

import br.com.lucaskevin.tarefa_09.dto.ClienteRequestDTO;
import br.com.lucaskevin.tarefa_09.dto.ClienteResponseDTO;
import br.com.lucaskevin.tarefa_09.service.ClienteService;
// Imports do Swagger/OpenAPI
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<ClienteResponseDTO> salvar(@Valid @RequestBody ClienteRequestDTO dto) {
        ClienteResponseDTO clienteSalvo = clienteService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @Operation(summary = "Listar todos os clientes",
            description = "Retorna uma lista paginada com todos os clientes cadastrados. Você pode customizar a paginação usando os parâmetros 'page', 'size' e 'sort'.",
            parameters = {
                    @Parameter(in = ParameterIn.QUERY, name = "page", description = "Número da página (começa em 0)", schema = @Schema(type = "integer", defaultValue = "0")),
                    @Parameter(in = ParameterIn.QUERY, name = "size", description = "Quantidade de elementos por página", schema = @Schema(type = "integer", defaultValue = "10")),
                    @Parameter(in = ParameterIn.QUERY, name = "sort", description = "Critério de ordenação no formato: propriedade,asc|desc. Exemplo: nome,asc", schema = @Schema(type = "string"))
            })
    @ApiResponse(responseCode = "200", description = "Lista de clientes retornada com sucesso")
    @GetMapping
    public ResponseEntity<Page<ClienteResponseDTO>> listar(@Parameter(hidden = true) Pageable pageable) {
        return ResponseEntity.ok(clienteService.listarTodos(pageable));
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
