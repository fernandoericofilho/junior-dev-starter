# Sugestões de melhoria

Seu trabalho ficou muito bem estruturado, com uma boa explicação das violações das formas normais e scripts claros e coerentes. Aqui vão alguns pontos para deixá-lo ainda mais completo:

- Você identificou corretamente os problemas de dependências parciais e transitivas, demonstrando boa compreensão da 2FN e 3FN.

- O uso da tabela `itens_pedido` foi muito adequado para modelar o relacionamento entre pedidos e produtos, permitindo múltiplos itens em um único pedido.

- Vale ressaltar que a abordagem de criar uma tabela de endereços separados (em vez de apenas `logradouro`) pode oferecer maior flexibilidade, permitindo ao cliente registrar vários endereços e mantendo o histórico de entregas mesmo em caso de alteração futura.

- Outro ponto que pode enriquecer o modelo é guardar o preço do produto no momento da venda na tabela `itens_pedido`, garantindo que alterações futuras de preço não afetem o histórico.

- Também pode ser interessante incluir campos de datas de cadastro e atualização nos produtos, bem como datas nos pedidos e itens, para fins de auditoria, controle de estoque e acompanhamento histórico.

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