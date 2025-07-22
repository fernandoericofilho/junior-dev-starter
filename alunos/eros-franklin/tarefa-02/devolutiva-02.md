## Violação das formas normais

### 1ª Forma Normal (1FN)

A 1FN exige **atomicidade dos dados**, ou seja, sem grupos repetitivos e sem valores compostos.  
No modelo, há violação da 1FN porque informações de cliente, produto, fornecedor e endereço estão misturadas em uma única tabela, gerando repetição de dados sempre que um cliente fizer mais de um pedido com produtos diferentes.

✅ **Resumo do que corrigir** no seu texto original:
- Use *atomicidade* no lugar de *atomocidade*
- Explique melhor a 1FN, pois de fato existe violação
- Ajuste pequenas concordâncias (por exemplo *consulta* em vez de *consulto*)
- Use **SERIAL** no lugar de **AUTO_INCREMENT**, pois o padrão do PostgreSQL é SERIAL

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
