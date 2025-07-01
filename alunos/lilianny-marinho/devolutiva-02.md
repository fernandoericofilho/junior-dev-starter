# Sugestões de melhoria

Seu resumo está direto ao ponto, o que é ótimo para captar a ideia principal da tarefa! Algumas sugestões para deixar o texto mais claro e completo:

- Na explicação da **1FN**, vale mencionar que além de dados repetidos, a mistura de diferentes entidades (cliente, produto, fornecedor) em uma mesma tabela também quebra o princípio de atomicidade.

- Sobre a **2FN**, é importante destacar que a ausência de tabelas intermediárias (como `itens_pedido`) prejudica o relacionamento muitos-para-muitos entre pedidos e produtos, e isso gera dependências parciais.

- Na **3FN**, você acertou em apontar a dependência entre atributos não-chave. Talvez seja legal exemplificar com o telefone do fornecedor dependendo do nome do fornecedor para facilitar o entendimento.

- Para a parte da resolução, sugiro melhorar a redação: “Cada tabela terá uma chave primária e usará chaves estrangeiras para garantir os relacionamentos entre as entidades.” Assim o texto fica mais fluido.

- Faltaram os **scripts SQL completos** para criação das tabelas normalizadas, bem como o **Diagrama Entidade-Relacionamento (DER)** que ajude a visualizar a estrutura e os relacionamentos do banco.

---

# Outras recomendações para enriquecer o trabalho

✅ **1. Separar endereço e telefone**
- Desmembrar o endereço em campos mais detalhados (logradouro, número, CEP etc.)
- Criar tabelas associativas para permitir múltiplos telefones por cliente e fornecedor

✅ **2. Gerenciamento de preços**
- Além do preço no produto, registrar o preço no momento da venda nos itens do pedido para preservar histórico

✅ **3. Inclusão de datas**
- Incluir data da venda nos itens do pedido
- Adicionar datas de cadastro, atualização e validade nos produtos

---
