## Apresentação pessoal - Murilo Lima

        Engenheiro de software júnior, com sólida base em desenvolvimento de produtos digitais, metodologias ágeis e gestão de projetos. Possui mestrado em Engenharia de Software e experiência prática na construção de aplicações full-stack utilizando JavaScript, Python e Django. Capacidade comprovada de colaborar com equipes multidisciplinares, traduzir requisitos de negócio em soluções escaláveis e entregar experiências de usuário de alta qualidade.

        Mais detalhes em https://github.com/omurilolima

## 📝 Tarefa

Após pelo menos 3 dias de estudo (mínimo de 1h por dia), escreva no arquivo `tarefa-01.md`:

### 1. O que você estudou?

    - Esta semana estou continuando o curso de React, que estou fazendo no codewithmosh.com;
    - Revisei os conceitos de Bancos de Dados Relacionais para a tarefa-01.
    - Revisei alguns conceitos de git pra facilitar a mudança de contexto/repositório entre o curso de react e esta tarefa.
    - Atualizei o perfil do Linkedin.

### 2. As fontes que utilizou

    - codewithmosh.com, chatGPT e Youtube

### 3. Um pequeno resumo com o que aprendeu (em 1 a 2 parágrafos)

        Sobre react, estou aprendendo a criar um site, coletanto o conteúdo de uma API, utilizando Axios. Aprendi a fazer fetch dos dados, apresentar skelletons enquanto os dados estão carregando, criar filtros e compartilhar useStates entre componentes.

        Sobre banco de Dados, revisei todos os conteúdos recomentados por Fernando, pra fixar melhor os conceitos, já que faz uns meses que criei um banco de dados.

### 💬 Extra: Explique com suas palavras

No final do seu resumo, **explique com suas próprias palavras**:

- O que são formas normais e qual a importância da normalização em um banco de dados?
- Dê um exemplo (simples) de como uma tabela mal estruturada pode ser melhorada usando normalização.

        Normalização é um processo de organização das tabelas de um banco de dados para: Eliminar dados repetidos, evitar anomalias e garantir integridade dos dados. É muito importante para trazer mais clareza, consistência nos dados e evitar problemas futuros.

#### ❌ Exemplo de violação da 2ª Forma Normal (2FN) - Eliminar dependência parcial

Problema: `nome_produto` e `preço_unitário` dependem somente de `produto_id`, não da chave composta inteira `pedido_id + produto_id`.

| pedido_id | produto_id | nome_produto | preço_unitário |
| --------- | ---------- | ------------ | -------------- |
| 101       | 10         | Teclado      | 150.00         |
| 101       | 11         | Mouse        | 80.00          |
| 102       | 10         | Teclado      | 150.00         |

#### ✅ Aplicando a 2FN, podemos separar os dados dependentes em outra tabela

Desta forma teremos uma tabela para registrar os produtos de cada pedido; e outra para registrar os dados fixos de cada produto

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
