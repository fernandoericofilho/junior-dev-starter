Emerson Soares Petrillo, 37 anos, São Paulo


Análise e Desenvolvimento de Sistemas, 3 semestre


Meu objetivo é atuar como Desenvolvedor de Software, utilizando minhas habilidades em Java, Kotlin, Spring Boot e o ecossistema DevOps (Docker, Kubernetes, Kafka) para projetar e construir soluções de back-end robustas e escaláveis. Busco aplicar meu conhecimento para resolver problemas de negócio complexos, otimizando processos e gerando valor através da criação de sistemas eficientes e inovadores, com especial interesse em arquiteturas de microsserviços e no setor financeiro.


Linkedin atualizado: https://www.linkedin.com/in/emersonpetrillo/


Estudos de Git and Github: https://www.youtube.com/watch?v=ts-H3W1uLMM


Estudo técnico introdutório + resumo:

Estudei os conceitos fundamentais de banco de dados, como modelagem de dados, entidades, relacionamentos, chaves primárias e estrangeiras, e também os princípios da normalização. Além disso, vi como utilizar o modelo relacional na prática, com exemplos de criação de tabelas e estruturas.

Fontes que utilizei:
- Curso no YouTube - Banco de Dados para Iniciantes: Link da playlist
- Curso no YouTube - Modelagem de Dados: Link da playlist
- Tutorial da DevMedia - Modelagem de Dados: https://www.devmedia.com.br/modelagem-de-dados-tutorial/20398

Resumo do que aprendi:

Com os estudos, aprendi que um banco de dados é uma ferramenta essencial para armazenar e organizar informações de forma estruturada. Entendi como funciona o processo de modelagem de dados, que envolve criar representações gráficas das informações, usando entidades, atributos e os relacionamentos entre eles. Também aprendi a importância de projetar bem o banco antes de implementá-lo, para evitar dados duplicados e garantir integridade. Outro ponto importante foi a normalização, que serve para organizar melhor os dados nas tabelas. Ela ajuda a evitar redundâncias e facilita a manutenção do banco. Vi exemplos práticos de como tabelas podem ser otimizadas e como isso influencia diretamente no desempenho e na clareza do sistema como um todo.

As formas normais são regras que ajudam a organizar as tabelas de um banco de dados relacional de forma lógica e eficiente. Cada forma normal (1FN, 2FN, 3FN, etc.) tem critérios que, quando aplicados, ajudam a eliminar problemas como redundância de dados, inconsistência e anomalias na atualização, inserção ou exclusão de dados. A normalização é importante porque torna o banco de dados mais claro, reduz o espaço ocupado com dados repetidos e facilita a manutenção e atualização das informações. Com ela, os dados ficam distribuídos em tabelas menores e bem conectadas por chaves, o que melhora a integridade e evita erros.

Exemplo de como uma tabela mal estruturada pode ser melhorada usando normalização:
Antes da normalização (estrutura mal feita):

ID_Aluno	Nome	Curso	Professor_Curso
1	Ana	Java	Carlos
2	João	Java	Carlos
3	Maria	Python	Paula

Nesse exemplo, os dados do curso e do professor estão sendo repetidos para cada aluno. Após aplicar normalização (separando em tabelas):

Tabela Aluno:
ID_Aluno	Nome
1	Ana
2	João
3	Maria

Tabela Curso:
ID_Curso	Nome	Professor
1	Java	Carlos
2	Python	Paula

Tabela Aluno_Curso (relação entre aluno e curso):
ID_Aluno	ID_Curso
1	1
2	1
3	2

Com isso, se o nome do professor de Java mudar, é só alterar em um único lugar, e não em várias linhas. Isso mostra na prática como a normalização ajuda na organização e manutenção dos dados.
