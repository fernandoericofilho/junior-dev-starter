#TAREFA 02

> Na primeiro script, onde temos violações com as regras 1FN, 2FN e 3FN:
- **1FN**: Dados repetidos como cliente e endereço.
- **2FN**: Dados que dependem parcialmente da chave.
- **3FN**: Dados como fornecedor_telefone dependem de fornecedor_nome.

# Resolvendo problema das violações
> Tabelas: Clientes - produtos - fornecedores - pedidos - itens
> Cada tabela vai possuir uma cham primária e usará chaves estrangeiras para que possa existir relacionamentos entra as entidades.
> Dessa forma, as repetições das informações irão ser elimanados.

