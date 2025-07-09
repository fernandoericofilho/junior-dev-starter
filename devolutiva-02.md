# ✅ Devolutiva – Tarefa 02

Olá, Marta! Parabéns pelo empenho e pelo cuidado em normalizar as tabelas. Seu relatório ficou bem estruturado e demonstra boa compreensão dos conceitos de modelagem relacional.

---

## 🌟 Pontos positivos

- Identificou corretamente as violações (1FN, 2FN, 3FN)
- Scripts bem organizados, com `DROP` e criação limpa das tabelas
- Boas práticas de integridade referencial usando **chaves estrangeiras**
- Inserção de dados coerente, demonstrando entendimento prático

---

## 🛠️ Sugestões de melhoria

- Poderia explicar um pouco mais sobre a escolha de separar telefone do cliente e do fornecedor (justificar modelagem)
- Comentar brevemente como as chaves estrangeiras evitam registros inválidos
- Tentar incluir mais comentários nos scripts para facilitar manutenção

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
