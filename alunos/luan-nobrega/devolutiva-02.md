# Devolutiva sobre sua resposta

Seu trabalho está muito bem elaborado, com uma explicação clara das violações das formas normais 2FN e 3FN e um modelo corrigido funcional que atende aos requisitos básicos da normalização. Parabéns pelo esforço!

Para enriquecer ainda mais seu trabalho, seguem algumas observações e sugestões:

---

### Pontos positivos

- A explicação dos problemas práticos, como redundância, risco de atualização, inserção e exclusão, está muito boa e ajuda a entender a importância da normalização.
- O uso de tabelas separadas para clientes, fornecedores, produtos, pedidos e itens_pedido é adequado para eliminar repetições e dependências transitivas.
- A inclusão da coluna `data_pedido` na tabela pedidos é um bom diferencial para controle temporal dos registros.
- O script está bem organizado e cobre a criação das tabelas e inserção dos dados.

---

### Pontos para melhorar

- **Endereço do cliente**: você armazenou o endereço como um campo único (varchar(200)) dentro da tabela clientes. Isso pode funcionar para um cenário simples, mas limita a flexibilidade do sistema.  
  **Sugestão:** separar o endereço em campos específicos (logradouro, número, CEP, cidade etc.) ou até criar uma tabela à parte de endereços para permitir múltiplos endereços por cliente.

- **Telefone**: assim como o endereço, clientes e fornecedores podem ter múltiplos telefones.  
  **Sugestão:** criar uma tabela associativa para telefones, permitindo registrar vários números por cliente ou fornecedor.

- **Preço dos produtos e itens do pedido**: o preço está correto na tabela produtos, mas para preservar a integridade histórica das vendas, o preço da venda deve ser registrado na tabela itens_pedido (ou em uma tabela de histórico de preços). Assim, alterações futuras no preço do produto não alteram dados históricos.

- **Fornecedor no itens_pedido**: você adicionou a coluna `fornecedor_id` em `itens_pedido`. Apesar de ser opcional, vale verificar se realmente há necessidade, pois o fornecedor do produto já está definido na tabela produtos, evitando redundância.

---

### Outras recomendações para melhorar ainda mais

✅ **1. Separar endereço e telefone**
- Desmembrar o endereço em campos específicos (logradouro, número, CEP, cidade etc.)
- Permitir múltiplos telefones para clientes e fornecedores usando uma tabela associativa

✅ **2. Gerenciamento de preços**
- Manter o preço no produto, mas também registrar o preço real da venda nos itens do pedido para garantir a integridade histórica dos dados

✅ **3. Adicionar datas**
- Incluir data do pedido nos registros de venda
- Adicionar data de cadastro/atualização e validade nos produtos

---
