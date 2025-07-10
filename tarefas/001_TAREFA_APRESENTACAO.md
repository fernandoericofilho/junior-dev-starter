# 📘 Tarefa 01 – Primeiros Passos da Jornada Dev JR

## 🎯 Objetivo

Dar os primeiros passos na organização de sua jornada como desenvolvedor(a) júnior, praticando sua apresentação pessoal, uso do Git, criação de repositório no GitHub e início do posicionamento profissional via LinkedIn.

Nesta etapa inicial, o foco está em **soft skills**, **autoconhecimento** e **prática básica com Git/GitHub**. Os conteúdos técnicos mais avançados (Java, Spring, Kafka, microservices, Kubernetes) virão nas próximas fases.

---

## 📅 Prazo sugerido

**5 a 7 dias**

---

## ✅ Entregas obrigatórias

## 1. Clonar o repositório base

- Acesse o repositório oficial do projeto:

  👉 [`https://github.com/fernandoericofilho/junior-dev-starter`](https://github.com/fernandoericofilho/junior-dev-starter)

- Clone o repositório em sua máquina:

  ```bash
  git clone https://github.com/fernandoericofilho/junior-dev-starter.git

- Navegue até a estrutura de alunos:

  ```bash
  cd junior-dev-starter/alunos
  
  mkdir joao-silva
  
  cd joao-silva
  ```

## 2. Criar arquivo de apresentação pessoal

Crie um arquivo chamado `tarefa-01.md` dentro da sua pasta.

### Escrever sua apresentação pessoal

No arquivo `tarefa-01.md`, escreva um texto curto de até 6 linhas com:

- Nome, cidade, formação atual (ou menção à transição de carreira)  
- Seu objetivo com a tecnologia  
- Suas principais motivações ou interesses  

💡 **Dica:** Você poderá usar esse texto no LinkedIn e como roteiro em entrevistas e apresentações futuras.
---

## 3. Estudo de Git básico + prática

Estude os seguintes comandos Git:

- `git status`  
- `git pull`  
- `git add`  
- `git commit -m "mensagem"`  
- `git push`  

Depois de criar e editar seu `tarefa-01.md`:

### Adicione o arquivo:

```bash
  git add .

  git commit -m "feat: adiciona tarefa 01 com apresentação pessoal"

  git push origin main
```
---

## 4. Atualizar o LinkedIn

Crie ou atualize seu perfil com:

- Foto profissional (pode ser simples, com boa iluminação)
- Título: Desenvolvedor(a) Júnior | Em transição para tecnologia (ou similar)
- Texto da apresentação pessoal na seção "Sobre"
- Adicione cursos, bootcamps ou projetos como experiências ou certificações

---

## 5. Estudo técnico introdutório + resumo

### Tema escolhido: Banco de Dados Relacional

Durante esta etapa, o objetivo é compreender os conceitos básicos que sustentam o uso de bancos de dados relacionais, com foco em:

---

### 📌 O que estudar:

1. **Conceitos fundamentais**
   - O que é um banco de dados relacional
   - Diferença entre banco de dados e sistema gerenciador de banco de dados (SGBD)
   - Estrutura de tabelas, colunas, linhas (tuplas) e chaves primárias/estrangeiras

2. **Modelagem relacional**
   - O que é um modelo entidade-relacionamento (ER)
   - Como entidades se relacionam
   - O que são atributos e relacionamentos

3. **Formas Normais (Normalização)**
   - O que é normalização e por que ela é importante
   - Entenda as três primeiras formas normais:
     - **1ª Forma Normal (1FN):** Eliminar dados repetidos e garantir atomicidade
     - **2ª Forma Normal (2FN):** Eliminar dependência parcial
     - **3ª Forma Normal (3FN):** Eliminar dependência transitiva
   - Exemplos práticos com tabelas simples

---

### 📝 Tarefa

Após pelo menos 3 dias de estudo (mínimo de 1h por dia), escreva no arquivo `tarefa-01.md`:

1. O que você estudou  
2. As fontes que utilizou  
3. Um pequeno resumo com o que aprendeu (em 1 a 2 parágrafos)

---

### 💬 Extra: Explique com suas palavras

No final do seu resumo, **explique com suas próprias palavras**:

- O que são formas normais e qual a importância da normalização em um banco de dados?
- Dê um exemplo (simples) de como uma tabela mal estruturada pode ser melhorada usando normalização.
