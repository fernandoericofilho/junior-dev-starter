# 🐱 Tarefa de Versionamento com Gitflow

## Contexto

Você deve praticar o fluxo completo do Gitflow criando um arquivo `frase.txt` e evoluindo seu conteúdo até a versão final, utilizando as branches conforme orientado.

---

## Enunciado

### 1️⃣ Branch de feature

- Crie uma branch chamada `feature/frase-gatinho` a partir da `master`.
- Dentro da sua pasta de trabalho, adicione o arquivo `frase.txt` com o conteúdo:
- Meu gatinho tomou agua e ficou triste !

- Faça o commit.

---

### 2️⃣ Branch de release

- A partir da branch de feature, crie a branch `release/v1.0.0`.
- Ajuste o arquivo `frase.txt` para conter:
- Meu gatinho tomou leite mas ficou triste !

- Faça o commit.

---

### 3️⃣ Branch de hotfix

- Após fazer o merge da release na `master`, crie a branch `hotfix/fix-frase-gatinho` a partir da `master`.
- Corrija o arquivo `frase.txt` para:
- Meu gatinho tomou leite e ficou feliz !
- Faça o commit e depois abra o pull request para a `master`.

---

## ✅ Resultado esperado

Ao final de todo o fluxo, a branch `master` deverá conter no arquivo `frase.txt` exatamente:

Meu gatinho tomou leite e ficou feliz !

---

## 📸 Entrega

- Tire um **print de cada etapa da árvore de commits/branches** (`git log --graph --all --oneline` recomendado)
- Faça também um **breve texto** explicando, com suas palavras, o que aconteceu em cada etapa do processo e qual foi o aprendizado.

---

**Observações finais:**
- Você **não** deve alterar diretamente a `master`.
- O merge final na master deve refletir a frase correta e completa.
- Exercite os comandos do git e aprenda seu funcionamento !