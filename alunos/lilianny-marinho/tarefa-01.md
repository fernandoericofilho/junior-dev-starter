# Lilianny Marinho

> Me chamo **Lilianny Gonçalves Marinho de Araújo**, sou de Santa Luzia, Paraíba, e atualmente curso Ciência da Computação na Universidade Estadual da Paraíba, em Patos. Tenho como objetivo me especializar no ramo de programação e desenvolvimento, evoluindo constantemente como pessoa e profissional. Minha motivação se baseia no desejo que tenho de quebrar barreiras, sejam elas técnicas ou linguísticas, podendo assim contribuir com ideias inovadoras e criativas. Acredito que a tecnologia pode transformar vidas e quero fazer parte dessas transformações, mostrando que **dedicação e foco permitem que possamos chegar a lugares incríveis**.

---

## 🎓 Fontes de Estudos:

- [CHAVE PRIMÁRIA (PK) E CHAVE ESTRANGEIRA (FK) NA PRÁTICA](https://youtu.be/1nVfkblf-c8?si=l0PKUD8SJg-7iUul)

- [Curso de SQL - Tabelas, Colunas e linhas](https://youtu.be/2y33edbRCRw?si=P-pkyqlS2vhiU9IP)

- [Você sabe a diferença entre Banco de Dados e SGBD? | CreateSe](https://youtu.be/yQkp1Eze400?si=SP_E5wjArwJ6Ob7M)

- [O Que É Banco De Dados Relacional?](https://youtu.be/tRK4-wkTt9I?si=7pOZzy8t9Dof2-E8)

- [Modelo entidade relacionamento](https://youtu.be/xN7B-_9YqAE?si=7_U4Td6KJlqhNLCH)

- [Normalização de Dados em Bancos de Dados (1FN, 2FN, 3FN)](https://youtu.be/TOFZQ5wm1UI?si=2PfepFaDgaTQyEar)

- [ChatGPT] 
    *Utilizado como guia de estudos.*

---

## Conteúdos Estudados 

- Conceito de Banco de Dados relacional 
- Diferença entre Banco de Dados e Sistema Gerenciador de Banco de Dados
- Composição de um banco (Tabela/Linhas/Colunas)
- Chave Primária e Chave Estrangeira
-  Modelo Entidade-Relacionamento ER
-  Normalização e suas formas.

---

## Resumo:

> Durante os estudos, revisei os conceitos fundamentais do **banco de dados relacional**, que organiza dados em tabelas estruturadas com linhas (tuplas) e colunas (atributos). Cada tabela representa uma **entidade**.

> Entendi a diferença entre **Banco de Dados (BD)**, que é o conjunto de dados organizados, e **Sistema Gerenciador de Banco de Dados (SGBD)**, que é o software que permite armazenar, consultar e gerenciar esses dados (como o PostgreSQL).

> Estudei também sobre a **chave primária**, que identifica unicamente cada registro em uma tabela, e a **chave estrangeira**, que permite criar relacionamentos entre diferentes tabelas. Além disso, aprendi sobre o **Modelo Entidade-Relacionamento (ER)**, que é uma forma gráfica de representar tabelas (entidades), atributos e relacionamentos no banco.

---

## 🧠 Normalização e Formas Normais

A **normalização** se trata de um processo que organiza os dados para evitar repetições, dependências desnecessárias e tornar o banco mais eficiente e fácil de manter. Ela é dividida em 3 formas normais:

- **1ª Forma Normal (1FN)**: elimina grupos repetitivos e garante que cada campo da tabela contenha valores atômicos (não divisíveis).
- **2ª Forma Normal (2FN)**: elimina dependências parciais, ou seja, quando um campo depende apenas de parte da chave primária.
- **3ª Forma Normal (3FN)**: elimina dependências transitivas, quando um campo depende de outro que não é chave primária.

---

## 📌 Exemplo

**Tabela Sem Normalização**

Pedido_ID | Cliente | Produto | Preço| Endereço
    1     |Ana Júlia|  Bolo   |10,00 | Rua A,45
    2     |Ana Júlia|  Pizza  |35,00 | Rua A,45
    2     |  João   |  Misto  |10,00 | Rua C,60

- Dados repetidos (Cliente, Preço, Endereço).
- Difícil de atualizar sem causar inconsistência.

**Tabela Com Normalização**

-  `clientes(cliente_id, nome, telefone)`
-  `produtos(produto_id, nome, preço)`
- `pedidos(pedido_id, cliente_id, endereco_entrega)`
- `itens_pedido(pedido_id, produto_id, quantidade)`

---

## ✨ Considerações Finais

A experiência de estudar banco de dados relacionais me ajudou a compreender como os dados são organizados, gerenciados e relacionados. Entender os conceitos de **chaves**, **modelagem ER** e **normalização**, essencial para perceber a importância de construir bancos limpos e eficientes.
