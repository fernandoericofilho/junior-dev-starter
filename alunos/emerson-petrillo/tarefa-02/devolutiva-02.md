# ✅ Devolutiva – Tarefa 02

Olá! Parabéns pelo esforço e pela entrega detalhada da tarefa 02. Você apresentou um bom entendimento sobre as formas normais e conseguiu aplicar na prática a criação das tabelas e o relacionamento correto entre elas.

---

## 🌟 Pontos Positivos

- **Boa explicação das violações das formas normais (1FN, 2FN, 3FN)**  
  Você explicou claramente cada forma normal e como os problemas ocorrem, facilitando o entendimento dos conceitos.

- **Aplicação prática via scripts SQL**  
  O uso dos scripts para criar as tabelas e inserir dados demonstra que você compreendeu a estruturação correta do banco relacional.

- **Separação correta das entidades**  
  Clientes, fornecedores, produtos, pedidos e itens do pedido estão organizados em tabelas específicas, com as chaves primárias e estrangeiras bem definidas.

- **Referências e integridade referencial**  
  As constraints de chave estrangeira ajudam a manter a integridade dos dados e mostram preocupação com a qualidade do modelo.

- **Exemplo claro e coerente**  
  A inserção dos dados nas tabelas e o relacionamento entre eles ficou bem exemplificado.

---

## 🛠️ Sugestões para melhorar

- **Revisar pequenos erros de digitação e formatação**  
  Exemplo: “regsitros” deve ser “registros”; “por mais que sejam valores atômicos, é identificado...” poderia ser melhor estruturado para maior clareza.

- **Aprofundar um pouco mais a explicação das violações da 2ª e 3ª formas normais**  
  No texto, o conceito pode ser expandido para explicar melhor dependência total da chave primária e dependência transitiva.

- **Incluir comentários nas tabelas para reforçar o papel das chaves**  
  Pequenos comentários explicativos dentro do script SQL poderiam ajudar quem ler a entender a finalidade de cada campo.

- **Adicionar um pequeno resumo final**  
  Um parágrafo que destaque como a normalização melhora a eficiência, reduz redundância e facilita manutenção seria um bom fechamento.

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