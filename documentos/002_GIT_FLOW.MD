# 📄 Documentação – Processo de Commit e Pull Request no Git

Este documento orienta sobre as boas práticas e os comandos necessários para realizar commits e abrir pull requests (PRs) de forma segura, utilizando Git.

---

## 📌 Fluxo recomendado

1. Crie sua branch **sempre a partir da `master`**
2. Atualize a branch com a `master` antes de começar a codar, para reduzir conflitos
3. Implemente suas alterações
4. Faça commits claros e objetivos
5. Suba sua branch para o repositório remoto
6. Abra o Pull Request (PR)
7. Aguarde revisão e realize ajustes, se necessário

---

## 1️⃣ Atualizar a master local

Sempre garanta que a sua `master` está atualizada com o repositório remoto:

```
  git checkout master
  git pull origin maste
```

## 2️⃣ Criar a branch de trabalho a partir da master

Crie a branch já a partir da master atualizada:

```
    git checkout -b feature/minha-feature
```

# Dica: use nomes padronizados como feature/nome-da-feature ou bugfix/nome-do-bug.

## 3️⃣ Antes de começar a codar, atualizar a branch criada com a master novamente

Para garantir que não ficaram alterações pendentes na master desde a hora que você criou sua branch:

```
    git fetch origin
    git merge origin/master
```

ou, se preferir rebase:

```
    git rebase origin/master
```

Isso ajuda a detectar conflitos logo no início do trabalho.

## 4️⃣ Implementar as alterações

Trabalhe normalmente nos arquivos e faça as alterações necessárias no seu código.

## 5️⃣ Verificar o que mudou

Visualize os arquivos modificados:

```
    git status
```

Para detalhes do que mudou:

```
    git diff
```

## 6️⃣ Adicionar os arquivos para commit

Para adicionar arquivos específicos:

```
    git add caminho/do/arquivo
```

Ou para adicionar todos os arquivos modificados:

```
    git add .
```

## 7️⃣ Realizar o commit

Crie uma mensagem clara e objetiva:

```
    git commit -m "Adiciona regra de validação no cadastro de cliente"
```

ou, se quiser abrir o editor interativo:

```
    git commit
```

**Boas práticas para mensagens de commit:**

- `feat:` uma nova feature (recurso) que você está adicionando a uma aplicação específica
- `fix:` a resolução de um bug
- `style:` recurso e atualizações relacionadas à estilização
- `refactor:` refatoração de uma seção específica da base de código
- `test:` tudo o que for relacionado a testes
- `docs:` tudo o que for relacionado à documentação
- `chore:` manutenção regular do código

Você também pode usar **emojis** para representar visualmente esses tipos de commit, se quiser padronizar ainda mais.
## 8️⃣ Sincronizar novamente com a master antes de subir

Caso tenha ficado muito tempo desenvolvendo e queira garantir que conflitos foram resolvidos:

```
    git fetch origin
    git merge origin/master
```

ou

```
    git rebase origin/master
```

## 9️⃣ Subir sua branch para o repositório remoto

```
    git push origin feature/minha-feature
```

## 🔟 Abrir o Pull Request (PR)

Acesse a plataforma (por exemplo, GitHub)

Compare a branch de origem (sua branch) com a de destino (master)

Escreva um título claro e uma descrição objetiva do que mudou

Marque revisores, se necessário

Crie o PR

## 1️⃣1️⃣ Ajustes após comentários no PR

Caso alguém solicite alterações no PR:

Atualize novamente sua branch com a master:

```
    git fetch origin
    git merge origin/master
```

ou

```
    git rebase origin/master
```

Faça os ajustes necessários, commit normalmente:

```
    git add .
    git commit -m "Ajustes de revisão"
    git push origin feature/minha-feature
```


## ✅ Boas práticas

Commits pequenos e objetivos

Mensagens claras no padrão imperativo (ex: "Ajusta layout do formulário")

PRs bem descritos, explicando a motivação da alteração

Respeitar comentários de revisão

Nunca fazer force push na master

Sempre revisar e testar localmente antes de subir