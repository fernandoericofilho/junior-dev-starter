# Sugestões de melhoria

Seu trabalho está muito bem estruturado, com uma boa explicação das violações das formas normais e uma modelagem clara e funcional. Algumas observações para deixar o trabalho ainda mais completo:

- A análise da 1FN poderia enfatizar que, embora não existam campos multivalorados explícitos, a mistura de informações de clientes, produtos e fornecedores numa única tabela compromete a atomicidade dos dados e gera redundância.

- Na modelagem normalizada, a decisão de manter o campo `endereco_entrega` diretamente na tabela `clientes` funciona para cenários simples, mas pode limitar a flexibilidade do sistema. Recomendo considerar separar os endereços em uma tabela própria, para permitir múltiplos endereços por cliente e facilitar manutenções futuras.

- Além disso, para manter o histórico fiel dos pedidos, seria interessante guardar o preço do produto no momento da venda dentro da tabela `pedidos` ou, melhor ainda, numa tabela `itens_pedido` (que relaciona pedidos a produtos). Assim, variações no preço do produto ao longo do tempo não afetam os registros históricos.

- Por fim, uma sugestão que foge um pouco do escopo inicial, mas que agrega valor: adicionar campos de datas — como data do pedido, data de cadastro e validade dos produtos — pode ajudar no controle e auditoria dos dados.

---

# Outras recomendações para melhorar ainda mais

✅ **1. Separar endereço e telefone**
- Desmembrar o endereço em campos específicos (logradouro, número, CEP, cidade etc.)
- Considerar múltiplos telefones para clientes e fornecedores usando uma tabela associativa

✅ **2. Gerenciamento de preços**
- Manter o preço no produto, mas também registrar o preço real da venda nos itens do pedido para garantir a integridade histórica dos dados

✅ **3. Adicionar datas**
- Incluir data do pedido nos registros de venda
- Adicionar data de cadastro/atualização e validade nos produtos

---
