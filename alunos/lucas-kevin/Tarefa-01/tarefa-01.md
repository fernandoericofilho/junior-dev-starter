## Apresentação Pessoal

Me chamo Lucas Kevin Silva de Carvalho tenho 23 anos e moro na cidade de São Paulo.
Estou cursando o 2° semestre de Análise e Desenvolvimento de Sistemas (USJT). Venho de uma transição de carreira, atuei como técnico mecatrônico na área de automação industrial onde tive muito contato com algoritimo e lógica.

Meu objetivo é me tornar um desenvolvedor de software com foco em instituições financeiras. Atualmente busco me aprimorar na área e estou estudando para trabalhar efetivamente com desenvolvimento, acredito que a melhor forma de aprender é na prática, executando toda teoria que é aprendida. Sempre fui muito criativo e acredito que a tecnologia consegue proporcionar essa liberdade de criar coisas incríveis e resolver problemas, penso que nada é impossível e tudo tem uma solução, e encontrar essa resposta é o que me motiva.


## Estudo técnico introdutório

Durante os estudos, aprendi os conceitos fundamentais de um banco de dados relacional, como o que é um banco, para que serve e como ele é estruturado. Estudei também sobre modelagem relacional, onde entendi o que são entidades, atributos e relacionamentos, além da importância das chaves primárias e estrangeiras na organização dos dados. Outro ponto muito importante foi entender o que é normalização, por que ela é usada e como ela melhora a estrutura dos bancos.

Além da teoria, vi na prática como criar tabelas, como essas tabelas se relacionam e como aplicar as regras de normalização para evitar problemas como dados repetidos e dificuldades na manutenção do banco.

---

Um banco de dados relacional é uma forma de armazenar informações organizadas em tabelas. Nessas tabelas, os dados se relacionam entre si através de campos chamados chaves. Isso permite consultar e organizar as informações de forma eficiente. O SGBD é basicamente a plataforma que permite criar, acessar, alterar e gerenciar esses dados.

Outro conceito muito importante foi a normalização, que é um conjunto de regras que ajuda a organizar melhor as tabelas, evitando dados duplicados, informações desnecessárias e facilitando a manutenção.
A normalização funciona em etapas chamadas de formas normais, que são regras aplicadas para deixar os dados mais bem estruturados. As três principais são:

- 1ª Forma Normal (1FN): Garante que os dados estejam bem organizados, sem listas ou repetições dentro das células. Cada dado deve estar em um campo único e específico.

- 2ª Forma Normal (2FN): Organiza a tabela separando informações que não dependem completamente da chave principal. Isso evita que dados que só dependem de uma parte da chave fiquem misturados.

- 3ª Forma Normal (3FN): Remove informações que dependem de outra informação que não seja a chave principal, deixando o banco mais limpo, organizado e fácil de atualizar.


Antes (Tabela mal estruturada):

| Pedido | Cliente | Produto | Preço Produto |
| ------ |---------| ------- | ------------- |
| 1      | Ana     | Caneta  | 2,00          |
| 2      | João    | Caneta  | 2,00          |
| 3      | Marcela | Lápis   | 1,50          |

O preço do produto está sendo repetido em cada pedido. Se mudar, precisa alterar em vários lugares.

Depois da normalização (Tabelas separadas):

Tabela Cliente:

| ID\_Cliente | Nome  |
| ----------- | ----- |
| 1           | Ana   |
| 2           | João  |
| 3           | Maria |

Tabela Produto:

| ID\_Produto | Nome   | Preço |
| ----------- | ------ | ----- |
| 1           | Caneta | 2,00  |
| 2           | Lápis  | 1,50  |

Tabela Pedido:

| ID\_Pedido | ID\_Cliente | ID\_Produto |
| ---------- | ----------- | ----------- |
| 1          | 1           | 1           |
| 2          | 2           | 1           |
| 3          | 3           | 2           |

Agora, se o preço da caneta mudar, é só atualizar na tabela Produto, e não em todos os pedidos.

Comentário explicativo:
Neste modelo normalizado, as tabelas estão relacionadas por meio de chaves estrangeiras. A tabela Pedido conecta Cliente e Produto usando os campos ID_Cliente e ID_Produto, que se referem às chaves primárias nas respectivas tabelas. Isso permite armazenar os dados de forma organizada e evita duplicação, mantendo a integridade dos relacionamentos.

>Chaves:
As chaves primárias garantem que cada registro em uma tabela seja único e facilmente identificável, como o ID_Cliente na tabela de clientes. Já as chaves estrangeiras são utilizadas para criar relações entre tabelas, como o ID_Cliente e o ID_Produto presentes na tabela de pedidos, que se referem aos respectivos IDs nas tabelas Cliente e Produto. Essas chaves asseguram a integridade referencial, ou seja, evitam que sejam inseridos dados inválidos ou desconectados, mantendo a consistência das informações no banco de dados.

## Fontes Utilziadas

https://www.youtube.com/watch?v=E-2Ci1c_BXs

https://www.youtube.com/watch?v=hGstS10kCPM

https://www.youtube.com/watch?v=8fxKJWJcRTw&t=1377s

ChatGPT - para entender melhor conceitos de normalização, 1FN, 2FN e 3FN.

