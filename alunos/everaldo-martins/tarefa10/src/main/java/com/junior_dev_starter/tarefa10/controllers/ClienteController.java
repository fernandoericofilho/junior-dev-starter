package com.junior_dev_starter.tarefa10.controllers;

import com.junior_dev_starter.tarefa10.assemblers.ClienteResponseDTOAssembler;
import com.junior_dev_starter.tarefa10.dtos.ClienteRequestDTO;
import com.junior_dev_starter.tarefa10.dtos.ClienteResponseDTO;
import com.junior_dev_starter.tarefa10.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@Tag(name = "Clientes", description = "Endpoints para a gestão de clientes.")
public class ClienteController {

    private final ClienteService clienteService;
    private final ClienteResponseDTOAssembler assembler;
    private final PagedResourcesAssembler<ClienteResponseDTO> pagedAssembler;

    public ClienteController(
            ClienteService clienteService,
            ClienteResponseDTOAssembler assembler,
            PagedResourcesAssembler<ClienteResponseDTO> pagedAssembler) {
        this.clienteService = clienteService;
        this.assembler = assembler;
        this.pagedAssembler = pagedAssembler;
    }

    @Operation(summary = "Lista todos os clientes paginados", description = "Retorna uma lista paginada de todos os clientes, com links de navegação HATEOAS. A ordenação padrão é por 'id'.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listagem concluída com sucesso.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PagedModel.class))),
    })
    @GetMapping
    public ResponseEntity<PagedModel<ClienteResponseDTO>> listar(
            @Parameter(description = "Configurações de paginação (tamanho da página, número da página e ordenação).",
                    examples = @ExampleObject(name = "Exemplo de Paginação",
                            value = "page=0&size=10&sort=id,desc"))
            @PageableDefault(sort = "id") Pageable pageable) {

        Page<ClienteResponseDTO> pageDTO = clienteService.listarTodos(pageable);
        PagedModel<ClienteResponseDTO> pagedModel = pagedAssembler.toModel(pageDTO, assembler);

        return ResponseEntity.ok(pagedModel);
    }

    @Operation(summary = "Busca um cliente pelo ID", description = "Retorna um cliente pelo ID fornecido, com links HATEOAS para ações de atualização e remoção.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado com sucesso.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClienteResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Cliente com o ID especificado não foi encontrado.",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> buscarPorId(
            @Parameter(description = "ID do cliente a ser buscado.", required = true) @PathVariable Long id) {

        ClienteResponseDTO dto = clienteService.buscarPorId(id);
        ClienteResponseDTO modelComLinks = assembler.toModel(dto);

        return ResponseEntity.ok(modelComLinks);
    }

    @Operation(summary = "Busca clientes por nome", description = "Retorna uma lista paginada de clientes cujo nome contém o texto fornecido (case-insensitive), com links HATEOAS.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Clientes encontrados com sucesso.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PagedModel.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetro 'nome' não fornecido ou inválido.",
                    content = @Content)
    })
    @GetMapping("/nome/{nome}")
    public ResponseEntity<PagedModel<ClienteResponseDTO>> buscarClientesPorNome(
            @Parameter(description = "Nome do cliente a ser buscado.", required = true) @PathVariable String nome,
            @Parameter(description = "Configurações de paginação (tamanho da página, número da página e ordenação).",
                    examples = @ExampleObject(name = "Exemplo de Paginação",
                            value = "page=0&size=10&sort=nome"))
            @PageableDefault(sort = "nome") Pageable pageable) {

        Page<ClienteResponseDTO> pageDTO = clienteService.buscarClientesPorNomePaginado(nome, pageable);
        PagedModel<ClienteResponseDTO> pagedModel = pagedAssembler.toModel(pageDTO, assembler);

        return ResponseEntity.ok(pagedModel);
    }

    @Operation(summary = "Cria um novo cliente", description = "Adiciona um novo cliente no banco de dados, com validação de dados de entrada e retorna o cliente criado com links HATEOAS.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClienteResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados de cliente inválidos.",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<ClienteResponseDTO> salvar(
            @RequestBody(description = "Detalhes do cliente a ser criado.", required = true,
                    content = @Content(schema = @Schema(implementation = ClienteRequestDTO.class)))
            @Validated @org.springframework.web.bind.annotation.RequestBody ClienteRequestDTO dto) {

        ClienteResponseDTO salvo = clienteService.salvar(dto);
        ClienteResponseDTO modelComLinks = assembler.toModel(salvo);

        return ResponseEntity.status(HttpStatus.CREATED).body(modelComLinks);
    }

    @Operation(summary = "Atualiza um cliente pelo ID", description = "Atualiza um cliente existente no banco de dados com os dados fornecidos e retorna o cliente atualizado com links HATEOAS.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClienteResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Cliente com o ID especificado não foi encontrado.",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Dados de cliente inválidos.",
                    content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> atualizar(
            @Parameter(description = "ID do cliente a ser atualizado.", required = true) @PathVariable Long id,
            @RequestBody(description = "Novos detalhes do cliente.", required = true,
                    content = @Content(schema = @Schema(implementation = ClienteRequestDTO.class)))
            @Validated @org.springframework.web.bind.annotation.RequestBody ClienteRequestDTO dto) {

        ClienteResponseDTO atualizado = clienteService.atualizar(id, dto);
        ClienteResponseDTO modelComLinks = assembler.toModel(atualizado);

        return ResponseEntity.ok(modelComLinks);
    }

    @Operation(summary = "Remove um cliente pelo ID", description = "Remove um cliente do banco de dados pelo ID fornecido. Uma remoção bem-sucedida retorna um status 204 (No Content).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cliente removido com sucesso."),
            @ApiResponse(responseCode = "404", description = "Cliente com o ID especificado não foi encontrado.",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(
            @Parameter(description = "ID do cliente a ser removido.", required = true) @PathVariable Long id) {
        clienteService.remover(id);
        return ResponseEntity.noContent().build();
    }
}