package br.com.lucaskevin.tarefa_09.controller;

import br.com.lucaskevin.tarefa_09.dto.ClienteRequestDTO;
import br.com.lucaskevin.tarefa_09.dto.ClienteResponseDTO;
import br.com.lucaskevin.tarefa_09.service.ClienteService;
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
@Tag(name = "Clientes", description = "API para o gerenciamento de clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Operation(summary = "Criar um novo cliente", description = "Endpoint para cadastrar um novo cliente no sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso", content = @Content(schema = @Schema(implementation = ClienteResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Erro de validação nos dados enviados", content = @Content)
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

    @Operation(summary = "Buscar cliente por ID", description = "Retorna os dados de um cliente específico baseado no seu ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente encontrado com sucesso", content = @Content(schema = @Schema(implementation = ClienteResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado para o ID informado", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }
}