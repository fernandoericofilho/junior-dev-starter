## Apresentação pessoal - Murilo Lima

Engenheiro de software júnior, com sólida base em desenvolvimento de produtos digitais, metodologias ágeis e gestão de projetos. Possui mestrado em Engenharia de Software e experiência prática na construção de aplicações full-stack utilizando JavaScript, Python e Django. Capacidade comprovada de colaborar com equipes multidisciplinares, traduzir requisitos de negócio em soluções escaláveis e entregar experiências de usuário de alta qualidade.

Mais detalhes em https://github.com/omurilolima

---

## 📝 Tarefa

### 1. O que você estudou?

- Esta semana estou continuando o curso de React, que estou fazendo no codewithmosh.com;
- Revisei os conceitos de Bancos de Dados Relacionais para a tarefa-01.
- Revisei alguns conceitos de git pra facilitar a mudança de contexto/repositório entre o curso de React e esta tarefa.
- Atualizei o perfil do Linkedin.

### 2. As fontes que utilizou

- codewithmosh.com, chatGPT e Youtube

### 3. Um pequeno resumo com o que aprendeu (em 1 a 2 parágrafos)

Sobre React, estou aprendendo a criar um site, coletando o conteúdo de uma API, utilizando Axios. Aprendi a fazer fetch dos dados, apresentar skeletons enquanto os dados estão carregando, criar filtros e compartilhar useStates entre componentes.

Sobre Banco de Dados, revisei todos os conteúdos recomendados por Fernando, para fixar melhor os conceitos, já que faz alguns meses que criei um banco de dados.

---

### 💬 Extra: Explique com suas palavras

**O que são formas normais e qual a importância da normalização em um banco de dados?**

Formas normais são regras que ajudam a organizar os dados dentro de um banco de dados para eliminar redundâncias, evitar inconsistências e garantir a integridade dos dados. A normalização é importante porque traz clareza, reduz a duplicidade de dados e previne problemas futuros na manutenção e uso do banco.

**Exemplo simples de tabela mal estruturada que pode ser melhorada pela normalização**

Uma tabela que armazena `pedido_id`, `produto_id`, `nome_produto` e `preço_unitário` apresenta redundância porque o nome e o preço do produto são repetidos em vários pedidos. Isso viola a 2ª Forma Normal (2FN), pois `nome_produto` e `preço_unitário` dependem apenas do `produto_id`, não da chave composta inteira (`pedido_id + produto_id`).

Para corrigir, podemos separar em duas tabelas:

- Uma tabela que relaciona os pedidos e os produtos (`pedidos_produtos`), contendo só `pedido_id` e `produto_id`.
- Outra tabela para armazenar os dados fixos dos produtos (`produtos`), contendo `produto_id`, `nome_produto` e `preço_unitário`.

Dessa forma, evitamos a repetição e garantimos a consistência dos dados.

---

#### ❌ Exemplo de violação da 2ª Forma Normal (2FN) - Eliminar dependência parcial

| pedido_id | produto_id | nome_produto | preço_unitário |
| --------- | ---------- | ------------ | -------------- |
| 101       | 10         | Teclado      | 150.00         |
| 101       | 11         | Mouse        | 80.00          |
| 102       | 10         | Teclado      | 150.00         |

#### ✅ Aplicando a 2FN, podemos separar os dados dependentes em outra tabela

**Tabela: pedidos_produtos**

| pedido_id | produto_id |
| --------- | ---------- |
| 101       | 10         |
| 101       | 11         |
| 102       | 10         |

**Tabela: produtos**

| produto_id | nome_produto | preço_unitário |
| ---------- | ------------ | -------------- |
| 10         | Teclado      | 150.00         |
| 11         | Mouse        | 80.00          |
