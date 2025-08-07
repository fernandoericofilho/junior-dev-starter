## 9. Tarefa 09 – Cliente: Uso de DTOs, Optional e Princípio do Mínimo Privilégio

Nesta tarefa, você irá refatorar o CRUD da entidade Cliente, aplicando boas práticas de arquitetura como camadas bem definidas, uso de DTOs, e o princípio do mínimo privilégio, onde cada camada conhece apenas o necessário.

---

### 🎯 Objetivos

- Separar as responsabilidades entre Controller, Service e Repository
- Utilizar DTOs para entrada e saída de dados
- Garantir que a camada Controller não acesse diretamente o domínio
- Aplicar Optional no retorno de serviços
- Implementar um handler global de exceções

---

## ⚙️ Dependências necessárias

No pom.xml ou build.gradle, inclua as seguintes dependências:

- **Spring Web**
- **Spring Data JPA**
- **Flyway Migration**
- **H2 Database** (ou outro banco)
- **Lombok** (opcional)

---

### 🗂️ Estrutura Esperada

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
            │   ├── ClienteRequest.java
            │   └── ClienteResponse.java
            ├── model/
            │   └── Cliente.java
            ├── exception/
            │   └── GlobalExceptionHandler.java
            └── SeuProjetoApplication.java
```
---

## 🧩 Exemplo de Implementação

### 📁 model/Cliente.java

```
package com.example.primeiro_projeto.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
}
```

### 📁 dto/ClienteRequest.java

```
package com.example.primeiro_projeto.dto;

import lombok.Data;

@Data
public class ClienteRequestDTO {
    private String nome;
    private String email;
}
```

### 📁 dto/ClienteResponse.java

```
package com.example.primeiro_projeto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteResponseDTO {
    private Long id;
    private String nome;
    private String email;
}
```

### 📁 repository/ClienteRepository.java

```
package com.example.primeiro_projeto.repository;


import com.example.primeiro_projeto.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNomeLike(String prefix);
}
```

### 📁 service/ClienteService.java

```
package com.example.primeiro_projeto.service;

import com.example.primeiro_projeto.dto.ClienteRequestDTO;
import com.example.primeiro_projeto.dto.ClienteResponseDTO;
import com.example.primeiro_projeto.exception.ClienteNotFoundException;
import com.example.primeiro_projeto.model.Cliente;
import com.example.primeiro_projeto.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteResponseDTO salvar(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        Cliente salvo = clienteRepository.save(cliente);
        return toDTO(salvo);
    }

    public List<ClienteResponseDTO> listarTodos() {
        return clienteRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ClienteResponseDTO buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
        return toDTO(cliente);
    }

    public List<ClienteResponseDTO> buscaPorInicial(String prefixo) {
        return clienteRepository.findByNomeLike("%" + prefixo + "%")
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private ClienteResponseDTO toDTO(Cliente cliente) {
        return new ClienteResponseDTO(cliente.getId(), cliente.getNome(), cliente.getEmail());
    }
}
```

### 📁 controller/ClienteController.java

```
package com.example.primeiro_projeto.controller;

import com.example.primeiro_projeto.dto.ClienteRequestDTO;
import com.example.primeiro_projeto.dto.ClienteResponseDTO;
import com.example.primeiro_projeto.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ClienteResponseDTO salvar(@RequestBody ClienteRequestDTO dto) {
        return clienteService.salvar(dto);
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
}
```

### 📁 exception/GlobalExceptionHandler.java

```
package com.example.primeiro_projeto.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClienteNotFoundException.class)
    public ResponseEntity<String> handleNotFound(ClienteNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeral(Exception ex) {
        return ResponseEntity.status(500).body("Erro interno: " + ex.getMessage());
    }
}
```

### 📁 exception/ClienteNotFoundException.java

```
package com.example.primeiro_projeto.exception;

public class ClienteNotFoundException extends RuntimeException {
    public ClienteNotFoundException(Long id) {
        super("Cliente não encontrado com id: " + id);
    }
}

```
---

### 🧪 Testando com curl

### ✅ Requisição GET - Todos os clientes:
```
curl -X GET http://localhost:8080/clientes
```

### ✅ Requisição GET - Buscar por ID:
```
curl -X GET http://localhost:8080/clientes/1
```

### ✅ Requisição POST - Criar novo cliente:
```
curl -X POST http://localhost:8080/clientes \
-H "Content-Type: application/json" \
-d '{"nome": "João Silva", "email": "joao@exemplo.com"}'
```

---

🚀 EXTRA – Testando com Postman

- Abra o Postman e crie uma nova collection chamada API Cliente
- Adicione as seguintes requisições:

### ✅ GET - Listar todos
```
GET http://localhost:8080/clientes
```

### ✅ GET - Buscar por ID
```
GET http://localhost:8080/clientes/1
```

### ✅ POST - Criar
```
POST http://localhost:8080/clientes
Headers: Content-Type: application/json
Body:

{
  "nome": "Maria Oliveira",
  "email": "maria@exemplo.com"
}
```

---

### 📦 Tarefa

- Crie os arquivos conforme a estrutura proposta
- Teste os endpoints com curl ou Postman
- Exporte a collection e salve no repositório em /postman/clientes-collection.json

---

### 🧩 Tarefa Extra: Adicionar Swagger e Documentar o ClienteController

- Adicionar a dependência do Swagger (OpenAPI), configurar o Swagger na aplicação e documentar o ClienteController com anotações para descrição dos endpoints da entidade Cliente.

