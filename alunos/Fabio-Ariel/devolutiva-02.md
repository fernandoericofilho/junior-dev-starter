# Sugestões de melhoria

Seu trabalho está muito bom, claro e organizado. Aqui vão algumas observações que podem ajudar a aprimorar ainda mais o seu modelo:

- Você explicou bem as violações das formas normais, destacando corretamente os problemas de mistura de entidades e dependências parciais e transitivas.

- A modelagem das tabelas está correta, especialmente o uso da tabela `itens_pedido` para resolver o relacionamento muitos-para-muitos entre pedidos e produtos.

- Achei interessante você ter mantido o campo `endereco_entrega` diretamente na tabela `pedidos`. Essa abordagem facilita o registro do endereço no momento do pedido, o que é importante para manter o histórico mesmo que o cliente mude de endereço no futuro.

- Como sugestão, para um modelo ainda mais robusto, você pode pensar em separar os endereços em uma tabela própria com campos detalhados (logradouro, número, CEP, cidade etc.), permitindo múltiplos endereços por cliente. Assim, no pedido você pode referenciar esse endereço específico.

- Além disso, seria interessante incluir um campo para registrar o preço do produto no momento do pedido dentro da tabela `itens_pedido`. Isso ajuda a preservar o valor real da venda, caso o preço do produto mude depois.

- Por fim, incluir datas importantes, como data da venda nos itens do pedido e datas de cadastro/atualização nos produtos, pode ajudar em auditoria e controle.

---

# Outras recomendações para melhorar ainda mais

✅ **1. Separar endereço e telefone**
- Desmembrar o endereço em campos específicos (logradouro, número, CEP, cidade etc.)
- Considerar múltiplos telefones para clientes e fornecedores usando uma tabela associativa

✅ **2. Gerenciamento de preços**
- Além do preço no produto, manter o preço também nos itens do pedido, para registrar o valor efetivo da venda

✅ **3. Adicionar datas**
- Incluir data de venda nos itens de pedido
- Adicionar data de cadastro/atualização e data de validade nos produtos, para facilitar auditoria e controle de estoque

---
