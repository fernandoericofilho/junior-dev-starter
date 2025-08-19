## 📘 10. Tarefa 10 – Cliente: Validações, Paginação, Mapper, Testes e Documentação Avançada
Nesta tarefa, você irá evoluir o CRUD da entidade Cliente, adicionando boas práticas de validação, paginação, mapeamento, testes e documentação.

### 🎯 Objetivos

- Adicionar validações no DTO de entrada com Bean Validation
- Implementar paginação e ordenação no endpoint de listagem
- Utilizar Mapper (MapStruct ou conversão manual centralizada)
- Criar testes unitários e de integração
- Implementar logs estruturados para auditoria
- Melhorar a documentação com Swagger/OpenAPI

### ⚙️ Dependências adicionais

No pom.xml ou build.gradle:
- spring-boot-starter-validation
- mapstruct (opcional, se quiser usar mapper automático)
- spring-boot-starter-test

### 📂 Estrutura esperada

```
  src/
  └── main/
      └── java/
          └── com.seuprojeto/
              ├── controller/
              │   └── ClienteController.java
              ├── service/
              │   └── ClienteService.java
              ├── repository/
              │   └── ClienteRepository.java
              ├── dto/
              │   ├── ClienteRequestDTO.java
              │   └── ClienteResponseDTO.java
              ├── mapper/
              │   └── ClienteMapper.java
              ├── model/
              │   └── Cliente.java
              ├── exception/
              │   └── GlobalExceptionHandler.java
              └── SeuProjetoApplication.java
  └── test/
        └── java/com/seuprojeto/service/ClienteServiceTest.java
```

## 🧩 Exemplos de Implementação

### 👉 Os exemplos de código completos já foram mostrados na resposta anterior
.
Incluem:
- Validação com Bean Validation no ClienteRequestDTO
- Mapper centralizado em ClienteMapper
- Paginação com Pageable em ClienteService
- Swagger/OpenAPI no ClienteController
- Tratamento de validações em GlobalExceptionHandler
- Teste unitário em ClienteServiceTest

## 🧩 Novas implementações

### Validações com Bean Validation

```java
package com.example.primeiro_projeto.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClienteRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "Formato de e-mail inválido")
    private String email;
}
```

### Tratar os erros no GlobalExceptionHandler para retornar mensagens amigáveis.

```java
package com.example.primeiro_projeto.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClienteNotFoundException.class)
    public ResponseEntity<String> handleNotFound(ClienteNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> erros = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            erros.put(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(erros);
    }
}

```

### Paginação e Ordenação
```
GET http://localhost:8080/api/tarefas?page=0&size=5&sort=titulo,asc
- page=0 → primeira página.
- size=5 → quantidade de registros por página.
- sort=titulo,asc → ordena pelo campo titulo em ordem crescente.

Resposta esperada:
{
  "content": [
    {
      "id": 1,
      "nome": "João Silva",
      "email": "joao@exemplo.com"
    },
    {
      "id": 2,
      "nome": "Maria Oliveira",
      "email": "maria@exemplo.com"
    },
    {
      "id": 3,
      "nome": "Carlos Santos",
      "email": "carlos@exemplo.com"
    }
  ],
  "pageable": {
    "sort": {
      "sorted": true,
      "unsorted": false,
      "empty": false
    },
    "pageNumber": 0,
    "pageSize": 5,
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "totalPages": 2,
  "totalElements": 6,
  "last": false,
  "first": true,
  "numberOfElements": 3,
  "size": 5,
  "number": 0,
  "empty": false
}
```


### Uso de Pageable do Spring Data.

```java
package com.example.primeiro_projeto.controller;

import com.example.primeiro_projeto.dto.ClienteRequestDTO;
import com.example.primeiro_projeto.dto.ClienteResponseDTO;
import com.example.primeiro_projeto.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Operation(summary = "Criar cliente", description = "Cria um novo cliente")
    @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso")
    @PostMapping
    public ClienteResponseDTO salvar(@Validated @RequestBody ClienteRequestDTO dto) {
        return clienteService.salvar(dto);
    }

    @Operation(summary = "Listar clientes", description = "Lista todos os clientes com paginação")
    @ApiResponse(responseCode = "200", description = "Lista de clientes retornada com sucesso")
    @GetMapping
    public Page<ClienteResponseDTO> listar(Pageable pageable) {
        return clienteService.listarTodos(pageable);
    }

    @Operation(summary = "Buscar cliente por ID", description = "Busca um cliente pelo ID")
    @ApiResponse(responseCode = "200", description = "Cliente encontrado")
    @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    @GetMapping("/{id}")
    public ClienteResponseDTO buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }
}

---

package com.seuprojeto.service;

import com.seuprojeto.dto.ClienteRequestDTO;
import com.seuprojeto.dto.ClienteResponseDTO;
import com.seuprojeto.exception.ClienteNotFoundException;
import com.seuprojeto.mapper.ClienteMapper;
import com.seuprojeto.model.Cliente;
import com.seuprojeto.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    /**
     * Salva um novo cliente
     */
    public ClienteResponseDTO salvar(ClienteRequestDTO dto) {
        log.info("Iniciando criação de cliente com email={}", dto.getEmail());

        if (clienteRepository.existsByEmail(dto.getEmail())) {
            log.warn("Tentativa de criar cliente duplicado com email={}", dto.getEmail());
            throw new IllegalArgumentException("Email já cadastrado: " + dto.getEmail());
        }

        Cliente cliente = clienteMapper.toEntity(dto);
        Cliente salvo = clienteRepository.save(cliente);

        log.info("Cliente criado com sucesso id={} nome={} email={}", 
                 salvo.getId(), salvo.getNome(), salvo.getEmail());
        return clienteMapper.toDTO(salvo);
    }

    /**
     * Lista clientes com paginação
     */
    public Page<ClienteResponseDTO> listarTodos(Pageable pageable) {
        log.info("Listando clientes - page={} size={} sort={}", 
                 pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());
        Page<ClienteResponseDTO> pageDTO = clienteRepository.findAll(pageable)
                                                            .map(clienteMapper::toDTO);
        log.info("Total de clientes retornados nesta página={}", pageDTO.getNumberOfElements());
        return pageDTO;
    }

    /**
     * Busca cliente por ID
     */
    public ClienteResponseDTO buscarPorId(Long id) {
        log.info("Buscando cliente por id={}", id);
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Cliente não encontrado id={}", id);
                    return new ClienteNotFoundException(id);
                });
        log.info("Cliente encontrado id={} nome={} email={}", 
                 cliente.getId(), cliente.getNome(), cliente.getEmail());
        return clienteMapper.toDTO(cliente);
    }
}


---

package com.seuprojeto.repository;

import com.seuprojeto.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    /**
     * Busca clientes cujo nome contenha a string indicada (case insensitive) com paginação.
     * Uso típico: repository.findByNomeContainingIgnoreCase("joao", pageable)
     */
    Page<Cliente> findByNomeContainingIgnoreCase(String nome, Pageable pageable);

    /**
     * Busca clientes cujo nome contenha a string indicada (case insensitive) sem paginação.
     */
    List<Cliente> findByNomeContainingIgnoreCase(String nome);

    /**
     * Busca um cliente por email.
     */
    Optional<Cliente> findByEmail(String email);

    /**
     * Verifica existência por email (útil para validação antes de salvar).
     */
    boolean existsByEmail(String email);
}
```

### Mapper (MapStruct ou conversor manual)

```java
Centralizar a conversão Cliente ↔ DTO em uma classe Mapper para reduzir duplicação de código.

package com.example.primeiro_projeto.mapper;

import com.example.primeiro_projeto.dto.ClienteRequestDTO;
import com.example.primeiro_projeto.dto.ClienteResponseDTO;
import com.example.primeiro_projeto.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        return cliente;
    }

    public ClienteResponseDTO toDTO(Cliente cliente) {
        return new ClienteResponseDTO(cliente.getId(), cliente.getNome(), cliente.getEmail());
    }
}
```

### Testes Unitários e de Integração

```java
Unitários: testar ClienteService com mocks (Mockito ou Mockk no Kotlin).
Integração: usar @SpringBootTest + banco em memória (H2).
Cobrir cenários de sucesso e falha.

package com.example.primeiro_projeto.service;

import com.example.primeiro_projeto.dto.ClienteRequestDTO;
import com.example.primeiro_projeto.mapper.ClienteMapper;
import com.example.primeiro_projeto.model.Cliente;
import com.example.primeiro_projeto.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ClienteServiceTest {

    @Test
    void deveSalvarClienteComSucesso() {
        ClienteRepository repository = Mockito.mock(ClienteRepository.class);
        ClienteMapper mapper = new ClienteMapper();
        ClienteService service = new ClienteService(repository, mapper);

        ClienteRequestDTO dto = new ClienteRequestDTO();
        dto.setNome("Teste");
        dto.setEmail("teste@email.com");

        Cliente cliente = mapper.toEntity(dto);
        cliente.setId(1L);

        Mockito.when(repository.save(Mockito.any())).thenReturn(cliente);

        assertEquals("Teste", service.salvar(dto).getNome());
    }
}
```

### Logs Estruturados

```
Incluir logs com contexto:
log.info("Criando cliente com email={}", dto.getEmail());
Usar Slf4j (via Lombok) para padronizar logs.

```
### Documentação OpenAPI mais rica

```java
Usar anotações como:
@Operation(summary = "Buscar cliente por ID", description = "Retorna um cliente pelo seu ID")
@ApiResponse(responseCode = "200", description = "Cliente encontrado")
@ApiResponse(responseCode = "404", description = "Cliente não encontrado")
```

### (Opcional) HATEOAS / Links REST

HATEOAS é um princípio de arquitetura REST que sugere que a resposta da API deve fornecer links para as ações relacionadas, permitindo que o cliente navegue dinamicamente pelo sistema sem precisar conhecer previamente os endpoints.
Em outras palavras, o servidor guia o cliente sobre o que pode ser feito a seguir, incluindo links como self, update, delete ou all, dentro do próprio JSON de resposta.

```json
Retornar links no ClienteResponseDTO, ex:

{
  "id": 1,
  "nome": "João Silva",
  "email": "joao@exemplo.com",
  "_links": {
    "self": "/clientes/1",
    "update": "/clientes/1",
    "delete": "/clientes/1",
    "all": "/clientes"
  }
}
```

### 📜 Lista de commits sugeridos

Para manter o histórico organizado, sugiro criar os commits nesta ordem:

- feat: adicionar validações com Bean Validation no ClienteRequestDTO
- Incluir anotações @NotBlank, @Email, @Size
- Atualizar GlobalExceptionHandler para tratar MethodArgumentNotValidException.
- feat: implementar paginação e ordenação na listagem de clientes
- Usar Pageable no ClienteService e ClienteController.
- refactor: criar ClienteMapper para centralizar conversões entre DTO e entidade
- Substituir lógica duplicada em ClienteService.
- test: adicionar testes unitários para ClienteService
- Criar ClienteServiceTest com Mockito para validar comportamento.
- feat: adicionar logs estruturados na camada de serviço
- Usar Slf4j (Lombok) para registrar operações relevantes.
- docs: documentar endpoints do ClienteController com Swagger/OpenAPI
- Usar @Operation e @ApiResponse para enriquecer a documentação.
- test: adicionar testes de integração com SpringBootTest e H2
- Validar fluxo real de salvar e buscar clientes.

### 🧪 Testando

Via Swagger

- POST /clientes – cria cliente validando os campos
- GET /clientes?page=0&size=5&sort=nome,asc – lista clientes paginados
- GET /clientes/{id} – busca cliente por ID
- Incluir prints no PR

Via Postman

- Criar collection API Cliente Avançada com os mesmos endpoints da Tarefa 9, mas incluindo os parâmetros de paginação.

### 🧪 Testes de integração com H2

```java
@SpringBootTest
@AutoConfigureMockMvc
class ClienteControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveCriarEListarClienteComSucesso() throws Exception {
        String json = """
            { "nome": "Maria Silva", "email": "maria@teste.com" }
            """;

        mockMvc.perform(post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());

        mockMvc.perform(get("/clientes?page=0&size=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].nome").value("Maria Silva"));
    }
}
```

### 📦 Tarefa final

- Refatore o código da Tarefa 9 seguindo os novos pontos
- Commits organizados conforme lista acima
- Testar os endpoints via Swagger e Postman

### 📌 Agora preciso que você exporte a nova collection do Postman (com os endpoints da Tarefa 10, incluindo paginação) e salve no repositório em:

- /postman/clientes-collection-v2.json
