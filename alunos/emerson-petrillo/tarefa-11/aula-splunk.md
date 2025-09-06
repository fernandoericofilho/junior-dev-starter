# Tarefa 11 - Aula Splunk

## Comandos utilizados para buscas refinadas no Splunk:

- Parte 1 – Básico

index="main"

index="main" "Error"

index="main" 404

index="main" earliest="09/01/2025:09:00:00" latest="09/01/2025:09:05:00"

index="main" user="paulo"

- Parte 2 – Campos e filtros

index="main" service="PaymentService"

index="main" action="CreateOrder"

index="main" | dedup ip

index="main" code=500 | stats count

index="main" | top limit=5 user


- Parte 3 – Estatísticas com stats

index="main" | stats count by status

index="main" | stats count by service

index="main" | stats avg(value)

index="main" | stats count by ip | sort -count | head 10

index="main" | timechart span=1m count


- Parte 4 – Dashboards e alertas

index="main" (status="Error" OR status="Failed" OR status="Declined" OR status="Critical" OR status="Timeout") | stats count by status | sort -count

index="main" | timechart span=1h count

index="main" code=500

index="main" | top limit=3 user

index="main" | stats count
