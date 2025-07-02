# Sugestões de melhoria

✅ Na 1FN, Everaldo, você disse que não havia violação — mas na verdade existe, pois a tabela mistura cliente, fornecedor e produto em um só registro, gerando repetição de dados. Vale ajustar essa explicação.

✅ Na 3FN, você explicou bem, mas poderia reforçar que o `endereco_entrega` se repete em cada pedido do mesmo cliente, o que também é uma dependência transitiva.

✅ Cuidado na inserção dos pedidos: você criou 3 pedidos para representar itens de um mesmo pedido (ex.: Ana comprando teclado e mouse). Melhor criar **um único pedido** e depois listar os itens no `itens_pedido`, para manter consistência.

✅ Ortografia: corrija “Inseções exemplos” → **Inserções de exemplos**, e “forma normais” → **formas normais**.

✅ O print do DER é opcional, então poderia dizer isso no texto para quem for ler.

---

# Outras recomendações

✅ **Separar endereço e telefone de clientes e fornecedores**
- Criar atributos detalhados de endereço (logradouro, número, CEP etc.)
- Permitir múltiplos telefones (por exemplo usando tabela associativa de telefones)

✅ **Gerenciamento de preços**
- Incluir preço tanto na tabela de produtos (preço padrão)
- Quanto nos itens de pedido (preço aplicado na venda)

✅ **Adicionar datas**
- Colocar campos de data nos itens de pedido (data da venda)
- E nos produtos (data de cadastro, data de atualização e data de validade)

---
