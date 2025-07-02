# Análise e Sugestões para Apresentação Técnica de Francisco das Chagas Medeiros Neto

---

Seu texto apresenta uma boa introdução pessoal, explica de forma clara os conceitos de banco de dados relacionais e normalização, e inclui uma analogia simples e prática para ilustrar a importância da normalização. A apresentação tem tom pessoal e didático, o que é positivo para mostrar envolvimento e compreensão.

---

## ✅ Pontos Positivos

- **Apresentação pessoal direta e motivada:** você demonstra claramente seu objetivo profissional e interesse pela área, além de mencionar curiosidade e gosto pela resolução de problemas.
- **Explicação clara dos conceitos técnicos:** banco de dados relacionais, SGBD, modelagem ER e normalização estão bem descritos com linguagem acessível.
- **Exemplo prático simples:** a tabela dos pedidos e produtos ajuda a visualizar o problema de dados não normalizados.
- **Referência das fontes:** citar ChatGPT, Gemini e YouTube reforça sua pesquisa e diversidade de aprendizado.

---

## ✏️ Sugestões de Melhoria

### 1. Clareza e Coesão na Apresentação Inicial

- A frase sobre Git/GitHub está um pouco informal e pode causar uma impressão negativa. Sugiro reformular para mostrar que está aberto a aprender e que tem alguma familiaridade, mesmo que básica.

**Original:**  
"Git e Github: eu não estudei(Agora), pois acredito que já tenho minima noção doque fazer, mas sempre dou uma pesquisada caso não me lembre."

**Sugestão:**  
"Tenho noções básicas de Git e GitHub e estou sempre disposto a pesquisar e aprimorar meu conhecimento conforme necessário."

---

### 2. Repetição no Texto sobre Banco de Dados Relacionais

- O parágrafo que começa com "Um banco de dados relacional organiza os dados em tabelas..." repete conceitos já citados. Recomendo unir os parágrafos para evitar repetição e melhorar a fluidez.

---

### 3. Formatação da Tabela e Explicação da Normalização

- A tabela está boa para exemplificar, mas pode ser comentada para esclarecer o problema do modelo não normalizado, por exemplo:

```markdown
| Pedido | Cliente | Produto 1 | Produto 2 |
| ------ | ------- | --------- | --------- |
| 1001   | Ana     | Pão       | Leite     |
```

*Problema:* Se o cliente comprar mais de dois produtos, essa estrutura não comporta, dificultando a manutenção e o crescimento dos dados.

Após a normalização, dividimos os dados em duas tabelas:

- **Pedidos** (Pedido, Cliente)  
- **Itens do Pedido** (Pedido, Produto)

Assim, cada produto vira uma linha na tabela de itens, o que torna os dados mais organizados, flexíveis e fáceis de manter.
