# Devolutiva sobre seu trabalho de modelagem e normalização

Seu trabalho está bem organizado e mostra um bom entendimento das formas normais 1FN, 2FN e 3FN, além de trazer uma estrutura clara e didática, incluindo diagramas e referências. Parabéns!

Aqui estão alguns pontos para ajudar a aprimorar ainda mais:

---

### Pontos positivos

- Boa explicação teórica das violações e como o modelo foi normalizado.
- Divisão das tabelas em clientes, fornecedores e pedidos com as chaves estrangeiras adequadas.
- Inclusão do diagrama ER para ajudar na visualização do modelo.
- Uso de exemplos reais na inserção dos dados.
- Referências e recursos externos para aprofundamento.

---

### Pontos para melhorar

- **Separação entre Produtos e Pedidos:**  
  Atualmente, a tabela `pedidos` mantém os campos `produto_nome` e `produto_preco` diretamente, o que pode levar a redundância e inconsistências se um produto for vendido várias vezes.  
  **Sugestão:** criar uma tabela `produtos` separada e usar uma tabela intermediária `itens_pedido` para relacionar pedidos e produtos, permitindo múltiplos itens por pedido e preservando integridade.

- **Endereço e Telefone:**  
  Assim como no endereço, o campo `endereco_entrega` está numa única coluna em clientes, o que limita consultas e possíveis múltiplos endereços.  
  **Sugestão:** desmembrar endereço em campos atômicos (logradouro, número, CEP, cidade) ou criar tabela dedicada. Também considerar tabelas para múltiplos telefones.

- **Datas nas tabelas:**  
  Não há registro de datas, como data do pedido ou cadastro/atualização de produtos, que são importantes para controle histórico e auditoria.

- **Nomenclatura das colunas:**  
  Usar um padrão consistente nas colunas (ex: evitar repetir "cliente_" e "fornecedor_" em colunas das tabelas que já representam essas entidades).

- **Relacionamento entre fornecedor e produto:**  
  No modelo atual não há indicação de qual fornecedor fornece qual produto, o que pode ser importante para o negócio.

---

### Outras recomendações para enriquecer o trabalho

✅ **1. Separar endereço e telefone**
- Desmembrar endereço em campos específicos (logradouro, número, CEP, cidade etc.)
- Permitir múltiplos telefones por cliente e fornecedor via tabela associativa

✅ **2. Gerenciamento de preços**
- Criar tabela `produtos` para armazenar preço atual e outras informações do produto
- Registrar o preço da venda na tabela de itens do pedido para preservar o histórico

✅ **3. Adicionar datas**
- Incluir data do pedido, cadastro e validade nos produtos para controle e auditoria

---
