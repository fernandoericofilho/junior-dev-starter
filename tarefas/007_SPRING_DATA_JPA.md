# 📘 Tarefa 07 — Spring Data JPA e Mapeamento de Relacionamentos

## 🗓️ Prazo: 4 dias
**Data de entrega:** _(preencha conforme o dia atual)_

---

## 🎯 Objetivo
Nesta tarefa você deverá criar um **novo projeto Java com Spring Boot** utilizando o **Spring Data JPA** para reforçar o entendimento de:
- Mapeamento de entidades com anotações JPA
- Criação de relacionamentos entre tabelas
- Uso do Flyway para versionamento de scripts SQL
- Implementação de repositórios com métodos usando **JPA Query Methods**

---

## 🏗️ Estrutura do Projeto
O projeto deve conter **3 tabelas principais**:

### 1. `cliente`
- `id` (PK)
- `nome`
- `email`

### 2. `endereco`
- `id` (PK)
- `logradouro`
- `cidade`
- `estado`
- `cliente_id` (FK)

### 3. `telefone`
- `id` (PK)
- `numero`
- `tipo`
- `cliente_id` (FK)

---

## 🧩 Regras de Mapeamento
- Um `Cliente` pode ter **muitos Telefones**
- Um `Cliente` pode ter **um único Endereço**

Use as anotações `@OneToMany`, `@OneToOne`, `@ManyToOne`, `@JoinColumn`, etc. para mapear corretamente.

---

## 🔧 Scripts SQL (Flyway)

Crie um arquivo `V1__create_tables.sql` dentro da pasta `src/main/resources/db/migration` com o seguinte conteúdo:

```sql
CREATE TABLE cliente (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE endereco (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    logradouro VARCHAR(200),
    cidade VARCHAR(100),
    estado VARCHAR(50),
    cliente_id BIGINT UNIQUE,
    CONSTRAINT fk_endereco_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

CREATE TABLE telefone (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    numero VARCHAR(20),
    tipo VARCHAR(20),
    cliente_id BIGINT,
    CONSTRAINT fk_telefone_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);
```

Crie um arquivo `V2__insert_dados_iniciais.sql` dentro da pasta `src/main/resources/db/migration` com o seguinte conteúdo:

```sql
-- Inserindo clientes
INSERT INTO cliente (id, nome, email) VALUES
  (1, 'Ana Paula', 'ana.paula@example.com'),
  (2, 'Carlos Silva', 'carlos.silva@example.com');

-- Inserindo endereços
INSERT INTO endereco (id, rua, cidade, estado, cep, cliente_id) VALUES
  (1, 'Rua das Flores', 'São Paulo', 'SP', '01001-000', 1),
  (2, 'Avenida Brasil', 'Rio de Janeiro', 'RJ', '20040-001', 2);

-- Inserindo telefones
INSERT INTO telefone (id, numero, tipo, cliente_id) VALUES
  (1, '(11) 91234-5678', 'CELULAR', 1),
  (2, '(21) 3234-5678', 'FIXO', 2),
  (3, '(11) 93333-4444', 'CELULAR', 1);
```

## 📦 Entidades Java

Crie as classes `Cliente`, `Endereco` e `Telefone` com os devidos mapeamentos JPA.

---

## 📚 Repositórios

Implemente um `ClienteRepository` com pelo menos os seguintes métodos baseados em JPA Query Methods:

```java
List<Cliente> findByNomeContaining(String nome);
Optional<Cliente> findByEmail(String email);
List<Cliente> findByTelefones_Tipo(String tipo);
```

## 📖 Referência obrigatória

Use a documentação oficial para te auxiliar na construção dos métodos:  
👉 [Spring Data JPA - Query Methods](https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html)

---

## 📖 Exemplos 
### Palavras-chave suportadas em métodos do Spring Data JPA

| Palavra-chave         | Exemplo de método                                  | Trecho JPQL                                                | Exemplo de uso                                           |
|----------------------|-----------------------------------------------------|-------------------------------------------------------------|----------------------------------------------------------|
| `Distinct`           | `findDistinctBySobrenomeAndNome`                    | `select distinct … where x.sobrenome = ?1 and x.nome = ?2` | `findDistinctBySobrenomeAndNome("Silva", "João")`       |
| `And`                | `findByNomeAndSobrenome`                            | `… where x.nome = ?1 and x.sobrenome = ?2`                 | `findByNomeAndSobrenome("João", "Silva")`               |
| `Or`                 | `findByNomeOrSobrenome`                             | `… where x.nome = ?1 or x.sobrenome = ?2`                  | `findByNomeOrSobrenome("João", "Silva")`                |
| `Is`, `Equals`       | `findByNome`, `findByNomeIs`, `findByNomeEquals`    | `… where x.nome = ?1`                                      | `findByNome("João")`                                    |
| `Between`            | `findByDataNascimentoBetween`                       | `… where x.dataNascimento between ?1 and ?2`               | `findByDataNascimentoBetween(data1, data2)`             |
| `LessThan`           | `findByIdadeLessThan`                               | `… where x.idade < ?1`                                     | `findByIdadeLessThan(30)`                               |
| `LessThanEqual`      | `findByIdadeLessThanEqual`                          | `… where x.idade <= ?1`                                    | `findByIdadeLessThanEqual(30)`                          |
| `GreaterThan`        | `findByIdadeGreaterThan`                            | `… where x.idade > ?1`                                     | `findByIdadeGreaterThan(18)`                            |
| `GreaterThanEqual`   | `findByIdadeGreaterThanEqual`                       | `… where x.idade >= ?1`                                    | `findByIdadeGreaterThanEqual(18)`                       |
| `After`              | `findByDataCadastroAfter`                           | `… where x.dataCadastro > ?1`                              | `findByDataCadastroAfter(data)`                         |
| `Before`             | `findByDataCadastroBefore`                          | `… where x.dataCadastro < ?1`                              | `findByDataCadastroBefore(data)`                        |
| `IsNull`, `Null`     | `findByTelefoneIsNull`                              | `… where x.telefone is null`                               | `findByTelefoneIsNull()`                                |
| `IsNotNull`, `NotNull`| `findByTelefoneIsNotNull`                          | `… where x.telefone is not null`                           | `findByTelefoneIsNotNull()`                             |
| `Like`               | `findByNomeLike`                                    | `… where x.nome like ?1`                                   | `findByNomeLike("%Jo%")`                                |
| `NotLike`            | `findByNomeNotLike`                                 | `… where x.nome not like ?1`                               | `findByNomeNotLike("%Jo%")`                             |
| `StartingWith`       | `findByNomeStartingWith`                            | `… where x.nome like ?1%`                                  | `findByNomeStartingWith("Jo")`                          |
| `EndingWith`         | `findByNomeEndingWith`                              | `… where x.nome like %?1`                                  | `findByNomeEndingWith("ão")`                            |
| `Containing`         | `findByNomeContaining`                              | `… where x.nome like %?1%`                                 | `findByNomeContaining("an")`                            |
| `OrderBy`            | `findByIdadeOrderByNomeDesc`                        | `… where x.idade = ?1 order by x.nome desc`                | `findByIdadeOrderByNomeDesc(30)`                        |
| `Not`                | `findBySobrenomeNot`                                | `… where x.sobrenome <> ?1`                                | `findBySobrenomeNot("Silva")`                           |
| `In`                 | `findByIdadeIn`                                     | `… where x.idade in ?1`                                    | `findByIdadeIn(listOf(20, 30, 40))`                      |
| `NotIn`              | `findByIdadeNotIn`                                  | `… where x.idade not in ?1`                                | `findByIdadeNotIn(listOf(18, 21))`                      |
| `True`               | `findByAtivoTrue`                                   | `… where x.ativo = true`                                   | `findByAtivoTrue()`                                     |
| `False`              | `findByAtivoFalse`                                  | `… where x.ativo = false`                                  | `findByAtivoFalse()`                                    |
| `IgnoreCase`         | `findByNomeIgnoreCase`                              | `… where upper(x.nome) = upper(?1)`                        | `findByNomeIgnoreCase("joão")`                          |
| `And/Or` combinados  | `findByNomeAndAtivoOrSobrenome`                     | `… where (x.nome = ?1 and x.ativo = ?2) or x.sobrenome = ?3`| `findByNomeAndAtivoOrSobrenome("João", true, "Souza")`  |
| `Boolean com And`    | `findByAtivoTrueAndIdadeGreaterThan`               | `… where x.ativo = true and x.idade > ?1`                  | `findByAtivoTrueAndIdadeGreaterThan(18)`                |
| `Boolean com Or`     | `findByAtivoFalseOrTelefoneIsNull`                 | `… where x.ativo = false or x.telefone is null`            | `findByAtivoFalseOrTelefoneIsNull()`                    |


## ✅ Critérios de Aceitação

- Projeto compila e executa com Spring Boot
- Flyway cria as tabelas corretamente ao subir a aplicação
- Entidades estão corretamente mapeadas
- Relacionamentos entre as entidades estão funcionando
- Métodos no repositório retornam resultados corretos
- Código limpo, organizado e com boas práticas

---

## 📁 Entrega

Crie uma pasta chamada `tarefa07` dentro do seu diretório `alunos` e coloque o projeto finalizado lá.
Crie uma classe principal para executar as chamadas aos métodos que criou no repository.
Crie uma classe principal para testar um crud da interface JpaRepository

Inclua um arquivo `README.md` com instruções claras para rodar o projeto localmente, incluindo:

- Como subir o banco de dados
- Como rodar as migrations com Flyway
- Como executar e testar os resultados
- As anotações que utilizou e por quê?
- Um post no linkedin marcando a academia com o reultado dessa tarefa
