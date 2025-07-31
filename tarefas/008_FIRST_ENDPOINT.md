## 8. Tarefa 08 – Repository, Service e Controller com Spring Boot

Nesta tarefa, você irá complementar o projeto criado na Tarefa 07 implementando a **camada de serviço** (`Service`), **camada de controle** (`Controller`) e utilizando os repositórios para realizar operações básicas com a entidade `Cliente`.

---

### 🎯 Objetivos

- Criar endpoints RESTful com Spring Web
- Organizar as camadas de responsabilidade: Repository, Service e Controller
- Aplicar boas práticas de estrutura de projeto
- Realizar requisições com Postman ou `curl`

---

### ⚙️ Dependências necessárias

Acesse o [Spring Initializr](https://start.spring.io/) e adicione as seguintes dependências:

- **Spring Web**
- **Spring Data JPA**
- **Flyway Migration**
- **H2 Database** (ou outro banco de sua escolha)
- **Lombok** (opcional, para reduzir boilerplate)

Se você já criou o projeto na Tarefa 07, apenas adicione `Spring Web` ao `pom.xml` ou `build.gradle`, se ainda não estiver incluído.

---

### 🗂️ Estrutura Esperada

A estrutura básica da sua aplicação deve seguir este padrão:

```
  src/
  └── main/
  └── java/
  └── com/
  └── seuusuario/
  └── seuprojeto/
  ├── controller/
  │ └── ClienteController.java
  ├── service/
  │ └── ClienteService.java
  ├── repository/
  │ └── ClienteRepository.java
  ├── model/
  │ └── Cliente.java
  └── SeuProjetoApplication.java
```

---

### 🧩 Exemplo de Implementação

#### 📁 Repository

```java
  package com.seuprojeto.repository;
  
  import com.seuprojeto.model.Cliente;
  import org.springframework.data.jpa.repository.JpaRepository;
  
  public interface ClienteRepository extends JpaRepository<Cliente, Long> {
  }
```

#### 📁 Service

```
  package com.seuprojeto.service;
  
  import com.seuprojeto.model.Cliente;
  import com.seuprojeto.repository.ClienteRepository;
  import org.springframework.stereotype.Service;
  
  import java.util.List;
  
  @Service
  public class ClienteService {
  
      private final ClienteRepository clienteRepository;
  
      public ClienteService(ClienteRepository clienteRepository) {
          this.clienteRepository = clienteRepository;
      }
  
      public List<Cliente> listarTodos() {
          return clienteRepository.findAll();
      }
  
      public Cliente buscarPorId(Long id) {
          return clienteRepository.findById(id)
                  .orElseThrow(() -> new RuntimeException("Cliente não encontrado com id: " + id));
      }
  
      public Cliente salvar(Cliente cliente) {
          return clienteRepository.save(cliente);
      }
  }
```

#### 📁 Controller

```
  package com.seuprojeto.controller;
  
  import com.seuprojeto.model.Cliente;
  import com.seuprojeto.service.ClienteService;
  import org.springframework.web.bind.annotation.*;
  
  import java.util.List;
  
  @RestController
  @RequestMapping("/clientes")
  public class ClienteController {
  
      private final ClienteService clienteService;
  
      public ClienteController(ClienteService clienteService) {
          this.clienteService = clienteService;
      }
  
      @GetMapping
      public List<Cliente> listar() {
          return clienteService.listarTodos();
      }
  
      @GetMapping("/{id}")
      public Cliente buscarPorId(@PathVariable Long id) {
          return clienteService.buscarPorId(id);
      }
  
      @PostMapping
      public Cliente salvar(@RequestBody Cliente cliente) {
          return clienteService.salvar(cliente);
      }
  }

```

#### 🧪 Testando com curl
✅ Requisição GET de todos os clientes
```
  curl -X GET http://localhost:8080/clientes
```

✅ Requisição GET de todos os clientes
```
  curl -X GET http://localhost:8080/clientes/1
```

✅ Requisição GET de todos os clientes
```
  curl -X POST http://localhost:8080/clientes \
  -H "Content-Type: application/json" \
  -d '{"nome": "João da Silva", "email": "joao@exemplo.com"}'
```

---

## 🚀 EXTRA – Utilizar o Postman para Fazer as Chamadas e Agilizar Configurações

O Postman é uma excelente ferramenta para testar suas APIs de forma rápida e organizada. Nesta seção, você aprenderá a configurar e utilizar o Postman para testar os endpoints implementados nas tarefas anteriores.

---

### 🔧 Como Configurar o Postman

1. **Instale o Postman**  
   Baixe e instale o Postman em [https://www.postman.com/downloads/](https://www.postman.com/downloads/)

2. **Crie uma nova Collection**
   - Abra o Postman
   - Clique em `Collections` → `New Collection`
   - Dê um nome como `API Cliente`
   - Adicione uma breve descrição se quiser
   - Clique em `Create`

3. **Adicione Requisições à Collection**
   - Clique na collection criada → `Add Request`
   - Configure os seguintes exemplos:

---

### ✅ Requisição GET - Listar Clientes

- **Method**: `GET`  
- **URL**: `http://localhost:8080/clientes`  
- **Descrição**: Lista todos os clientes cadastrados.  

---

### ✅ Requisição GET - Buscar Cliente por ID

- **Method**: `GET`  
- **URL**: `http://localhost:8080/clientes/1`  
- **Descrição**: Retorna o cliente com ID 1.

---

### ✅ Requisição POST - Criar Cliente

- **Method**: `POST`  
- **URL**: `http://localhost:8080/clientes`  
- **Headers**:
  - `Content-Type: application/json`
- **Body (raw / JSON)**:

```json
{
  "nome": "Maria Oliveira",
  "email": "maria@exemplo.com"
}
```

💡 Dicas para Agilizar no Postman
✅ Use variáveis de ambiente como {{baseUrl}} para URLs reutilizáveis (ex: http://localhost:8080)
✅ Agrupe suas requisições por funcionalidades (Clientes, Endereços, Telefones)
✅ Salve exemplos de respostas mockadas para futuras comparações
✅ Utilize o botão "Beautify" no body JSON para melhor leitura
✅ Habilite o console do Postman (Ctrl + Alt + C) para debug

📦 Exportar e Compartilhar
- Você pode exportar sua collection com os testes criados e compartilhar com seus colegas ou instrutor:
- Vá na sua collection → clique com botão direito → Export
- Escolha o formato Collection v2.1 (recommended)
- Envie o arquivo .json ou suba no seu repositório GitHub

✅ Tarefa
- Crie e salve as requisições GET e POST no Postman
- Exporte a collection e salve no repositório em uma pasta chamada postman/
- Nomeie o arquivo como: clientes-collection.json
