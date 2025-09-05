# 🌐 Tarefa 11

## 📌 Parte 1 – Básico

1. **Pesquisar todos os eventos do índice main**

```spl
index=main
```

2. **Filtrar logs contendo “error”**

```spl
index=main status=error
```

3. **Buscar todos os acessos com status 404**

```spl
index=main 404
```

4. **Listar eventos de um período específico (ex: 01/09/2025 00:00 até 05/09/2025 23:59)**

```spl
index=main earliest=09/01/2025:00:00:00 latest=09/05/2025:23:59:59
```
* **Ou datas relativas (mais recomendadas)**
```spl
index="main" source="server.log" earliest=@d-5d latest=@d
```

5. **Filtrar apenas usuário admin**

```spl
index=main user=admin
```

---

## 📌 Parte 2 – Campos e filtros

6. **Buscar eventos sourcetype=access\_combined**

```spl
index=main sourcetype=access_combined_wcookie
```

7. **Filtrar por método POST**

```spl
index=main sourcetype=access_combined_wcookie POST
```

8. **Listar IPs únicos que acessaram o sistema**

```spl
index=main | stats dc(ip) by ip
```

* **Ou filtrar por regex**
```spl
index="main" | rex field=_raw "^server\d+\s+(?<ip>\S+)" | stats dc(ip) by ip
```

9. **Contar eventos com status 500**

```spl
index=main 500 | stats count
```

10. **Listar os 5 principais user agents**

```spl
index=main | top limit=5 useragent
```

* **Ou filtrar por regex**
```spl
index=main | rex field=_raw "\"(?<useragent>[^\"]+)\"\s+\d+$" | top limit=5 useragent
```

--- 

## 📌 Parte 3 – Estatísticas com stats

11. **Contar eventos por status**

```spl
index=main | stats count BY status
```

12. **Contar acessos por host**

```spl
index="main" | stats count BY host
```

13. **Calcular média de tempo de resposta**

```spl
index=main | stats avg(response_time) AS avg_response_time
```

* **Ou filtrar por regex**
```spl
index=main | rex field=_raw "\s(?<response_time>\d+)$" | stats avg(response_time) AS avg_response_time
```

14. **Listar os 10 IPs que mais acessaram o sistema**

```spl
index=main | top limit=10 ip
```

15. **Gerar gráfico de acessos por minuto**

```spl
index=main | timechart span=1m count
```

---

## 📌 Parte 4 – Dashboards e alertas

16. **Criar gráfico de barras de erros por status**

```spl
index=main status>=400 | stats count BY status
```

💻 Visualizar como **Bar Chart**.

17. **Criar gráfico de linha mostrando acessos por hora**

```spl
index=main | timechart span=1h count
```

💻 Visualizar como **Line Chart**.

18. **Configurar alerta: status 500 > 10 ocorrências/minuto**

```spl
index=main 500 | timechart span=1m count | where count > 10
```

💻 Salvar como **Alert**, trigger quando `count > 10`.

19. **Criar painel com os 3 usuários mais ativos**

```spl
index=main | top limit=3 user
```

💻 Salvar como painel no Dashboard.

20. **Criar dashboard combinando acessos totais e por status**

1️⃣ Consulta total:

```spl
index=main | stats count AS total_acessos
```

2️⃣ Consulta por status:

```spl
index=main | stats count BY status
```