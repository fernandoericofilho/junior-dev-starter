# Aula Prática Splunk Cloud (Trial de 14 dias)

---

## 📘 11. Aula e Tarefa 11 – Introdução e Configuração do Splunk Cloud

### 🎯 Objetivos da Aula
- Entender o cadastro e acesso ao Splunk Cloud Trial
- Aprender a navegar no Splunk Web
- Subir dados de exemplo para análise
- Executar consultas básicas (SPL)
- Criar dashboards simples

### 1️⃣ Cadastro no Splunk Cloud
1. Acesse [Splunk Cloud Trial](https://www.splunk.com/en_us/products/splunk-cloud-platform.html)  
2. Clique em **Start Free Trial**  
3. Preencha o formulário de cadastro e envie  
4. Ative sua conta pelo e-mail recebido  
5. Você receberá um email com os dados para login com(URl do Cloud, Usuário e Senha temporaria)

### 2️⃣ Acessando a Instância Trial
1. Faça login no [Splunk Portal](https://www.splunk.com/)  
2. Clique em **Start Trial** (se ainda não iniciou)  
3. Vá para a tela **Instances**, onde verá sua instância criada automaticamente  
- Status: **Active**  
- Tamanho: 5GB  
- Duração: 14 dias  
- Provisionamento leva de 5 minutos a 1 hora

### 3️⃣ Gerenciamento da Instância
- Botões: **Reset Password**, **Access Instance** (aguarde o provisionamento se estiver desabilitado)  
- Roles: você é admin por padrão  

### 4️⃣ Alternativas se o botão "Access Instance" não funcionar
- Splunk Enterprise Free (local)  
- Workshops oficiais da Splunk  
- Docker Splunk  

### 5️⃣ Acessando o Splunk Web
- **Search & Reporting** → executar buscas  
- **Dashboards** → criar painéis interativos  
- **Settings** → configurar inputs, usuários e permissões  

> Sem dados, as buscas não retornarão resultados  

### 6️⃣ Carregando dados de exemplo
1. Baixe o arquivo [tutorialdata.zip](./tutorialdata.zip) 
2. No Splunk Web, vá em **Settings → Add Data → Upload → Upload Files** e selecione o arquivo  
3. Siga o passo a passo. Confirme ou ajuste o **Sourcetype**  
4. Clique em **Submit** para indexar os dados  

> Indexação pode levar alguns segundos ou minutos  

### 7️⃣ Exemplos de consultas SPL (como texto)
- Contar todos os eventos: `index=main | stats count`  
- Filtrar logs de erro: `index=main error`  
- Contar acessos por status: `index=main | stats count by status`  
- Top 5 IPs: `index=main | top clientip limit=5`  

### 8️⃣ Como montar dashboards
1. Clique em **Dashboards → Create New Dashboard**  
2. Informe um **nome** e clique em **Create**  
3. Adicione **Panels**:  
   - Escolha **New Panel → Visualization** → selecione tipo (barra, linha, pizza)  
   - Insira a consulta SPL  
   - Configure título, cores e legendas  
4. Adicione outros gráficos ou tabelas conforme necessário  
5. Salve e visualize o dashboard  

Exemplos:  
- Gráfico de barras mostrando erros por status  
- Gráfico de linha com acessos por hora  
- Tabela com os 3 usuários mais ativos  
- Dashboard combinando contagem total e eventos por status  

---

## 📘 Tarefa – Prática com Splunk

### 🎯 Objetivos
- Executar buscas SPL básicas e avançadas  
- Filtrar e contar eventos  
- Criar gráficos e dashboards  
- Interpretar resultados e explorar os dados  

### 1️⃣ Exercícios sugeridos (20 questões)
#### Parte 1 – Básico
1. Pesquisar todos os eventos do índice `main`  
2. Filtrar logs contendo “error”  
3. Buscar todos os acessos com status `404`  
4. Listar eventos de um período específico  
5. Filtrar apenas usuário `admin`  

#### Parte 2 – Campos e filtros
6. Buscar eventos `sourcetype=access_combined`  
7. Filtrar por método `POST`  
8. Listar IPs únicos que acessaram o sistema  
9. Contar eventos com status `500`  
10. Listar os 5 principais user agents  

#### Parte 3 – Estatísticas com stats
11. Contar eventos por status  
12. Contar acessos por host  
13. Calcular média de tempo de resposta (`response_time`)  
14. Listar os 10 IPs que mais acessaram o sistema  
15. Gerar gráfico de acessos por minuto  

#### Parte 4 – Dashboards e alertas
16. Criar gráfico de barras de erros por status  
17. Criar gráfico de linha mostrando acessos por hora  
18. Configurar alerta: status 500 > 10 ocorrências/minuto  
19. Criar painel com os 3 usuários mais ativos  
20. Criar dashboard combinando acessos totais e por status  

### 2️⃣ Dicas de execução
- Use **Search & Reporting** para testar consultas  
- Salve consultas úteis para adicionar aos dashboards  
- Organize dashboards por tema (erros, acessos, usuários)  

---

### ✅ Próximos passos
- Explorar dashboards avançados  
- Criar alertas em tempo real  
- Integrar dados externos  
