#  Splunk - Consultas da Tarefa Prática

Este arquivo contém o resumo de todas as consultas SPL (Search Processing Language) utilizadas durante a tarefa prática com Splunk.

## Parte 1 – Básico

**1. Pesquisar todos os eventos do índice `main`**
* **Consulta:** `index="main"`
* **Resumo:** Esta é a busca mais fundamental. Ela retorna todos os eventos que foram indexados no índice chamado "main", permitindo uma visão geral de todos os dados disponíveis.

**2. Filtrar logs contendo “error”**
* **Consulta:** `index="main" "Error"`
* **Resumo:** Busca por qualquer evento no índice "main" que contenha a palavra "Error" em qualquer um de seus campos. É a forma mais simples de encontrar logs de erro.

**3. Buscar todos os acessos com status `404`**
* **Consulta (Adaptada):** `index="main" code=404`
* **Resumo:** Filtra os eventos para mostrar apenas aqueles onde o campo `code` tem o valor exato de `404`. Usado para encontrar problemas específicos, como "Página não encontrada".

**4. Listar eventos de um período específico**
* **Consulta:** `index="main" earliest="09/01/2025:09:00:00" latest="09/01/2025:09:05:00"`
* **Resumo:** Restringe a busca a um intervalo de tempo específico. Isso é crucial para analisar incidentes ou performance em janelas de tempo definidas.

**5. Filtrar apenas usuário `admin`**
* **Consulta (Adaptada):** `index="main" user="maria"`
* **Resumo:** Filtra eventos para mostrar a atividade de um usuário específico. Essencial para auditoria, troubleshooting de problemas de um usuário ou análise de comportamento.

## Parte 2 – Campos e filtros

**6. Buscar eventos `sourcetype=access_combined`**
* **Consulta (Adaptada):** `index="main" service="PaymentService"`
* **Resumo:** Isola eventos de uma fonte de dados ou serviço específico. Ajuda a focar a análise em um componente particular do sistema, como o serviço de pagamentos.

**7. Filtrar por método `POST`**
* **Consulta (Adaptada):** `index="main" action="CreateOrder"`
* **Resumo:** Filtra eventos com base em uma ação específica realizada. Útil para entender a frequência de operações críticas, como a criação de pedidos.

**8. Listar IPs únicos que acessaram o sistema**
* **Consulta:** `index="main" | dedup ip`
* **Resumo:** Remove eventos duplicados com base no campo `ip`, resultando em uma lista de eventos onde cada endereço IP aparece apenas uma vez. Usado para identificar quantos clientes distintos acessaram o sistema.

**9. Contar eventos com status `500`**
* **Consulta:** `index="main" code=500 | stats count`
* **Resumo:** Primeiro, filtra todos os eventos de erro crítico (`code=500`) e, em seguida, usa o comando `stats` para agregar os resultados em uma única contagem total.

**10. Listar os 5 principais user agents**
* **Consulta (Adaptada):** `index="main" | top limit=5 user`
* **Resumo:** Usa o comando `top` para encontrar os 5 usuários que mais geraram eventos. Ótimo para identificar os usuários mais ativos do sistema.

## Parte 3 – Estatísticas com `stats`

**11. Contar eventos por status**
* **Consulta:** `index="main" | stats count by status`
* **Resumo:** Agrupa todos os eventos pelos diferentes valores do campo `status` e conta quantos eventos existem para cada um. Gera uma tabela resumida da saúde das transações.

**12. Contar acessos por host**
* **Consulta (Adaptada):** `index="main" | stats count by service`
* **Resumo:** Similar à anterior, mas agrupa por `service`. Ajuda a identificar qual microsserviço ou componente do sistema está mais ativo ou gerando mais logs.

**13. Calcular média de tempo de resposta (response_time)**
* **Consulta (Adaptada):** `index="main" | stats avg(value)`
* **Resumo:** Calcula a média de um campo numérico (`value`). Neste caso, usamos para encontrar o valor médio das transações, mas o conceito se aplica a qualquer métrica, como tempo de resposta.

**14. Listar os 10 IPs que mais acessaram o sistema**
* **Consulta:** `index="main" | stats count by ip | sort -count | head 10`
* **Resumo:** Cria uma contagem de eventos por IP, ordena o resultado do maior para o menor, e exibe apenas os 10 primeiros. Uma forma poderosa de identificar as principais fontes de tráfego.

**15. Gerar gráfico de acessos por minuto**
* **Consulta:** `index="main" | timechart span=1m count`
* **Resumo:** Utiliza o comando `timechart` para criar uma série temporal, contando o número de eventos em intervalos de 1 minuto. É a base para qualquer gráfico de atividade ao longo do tempo.

## Parte 4 – Dashboards e Alertas

**16. Criar gráfico de barras de erros por status**
* **Consulta:** `index="main" (status="Error" OR status="Failed" OR status="Declined" OR status="Critical" OR status="Timeout") | stats count by status | sort -count`
* **Resumo:** Filtra apenas os status considerados como erro, conta-os e os ordena para criar uma visualização clara dos tipos de erro mais frequentes.

**17. Criar gráfico de linha mostrando acessos por hora**
* **Consulta:** `index="main" | timechart span=1h count`
* **Resumo:** Gera uma visualização da contagem de eventos ao longo do tempo, agrupados por hora, ideal para identificar padrões de uso diário.

**18. Configurar alerta: status 500 > 10 ocorrências/minuto**
* **Consulta:** `index="main" code=500`
* **Resumo:** Esta busca serve como base para um alerta. Ela retorna os eventos de erro, e a lógica do alerta (disparar se houver mais de 10 em um minuto) é configurada na interface do Splunk.

**19. Criar painel com os 3 usuários mais ativos**
* **Consulta:** `index="main" | top limit=3 user`
* **Resumo:** Gera uma tabela simples com os três principais usuários, pronta para ser adicionada como um painel em um dashboard de monitoramento.

**20. Criar dashboard combinando acessos totais e por status**
* **Consulta (Painel 1 - Acessos Totais):** `index="main" | stats count`
* **Consulta (Painel 2 - Pizza de Status):** `index="main" | stats count by status`
* **Resumo:** Duas consultas usadas para criar painéis diferentes em um mesmo dashboard. A primeira mostra um número único (total de eventos) e a segunda cria um gráfico de pizza para visualizar a distribuição dos status.
