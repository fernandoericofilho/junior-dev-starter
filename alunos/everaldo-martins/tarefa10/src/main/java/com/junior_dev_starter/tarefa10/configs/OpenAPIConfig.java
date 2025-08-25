package com.junior_dev_starter.tarefa10.configs;

import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestão de Clientes")
                        .description("Esta API RESTful permite a gestão completa de clientes. É possível criar, listar, buscar, atualizar e remover clientes de forma segura e paginada. A documentação segue as diretrizes do **HATEOAS** para garantir a navegabilidade entre os recursos.")
                        .version("1.0.0"));
    }

    @Bean
    public OpenApiCustomizer pageableOpenApiCustomizer() {
        return openApi -> openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
            if (operation.getParameters() != null) {
                operation.getParameters().stream()
                        .filter(parameter -> "pageable".equals(parameter.getName()) || "pageable".equals(parameter.getIn()))
                        .findFirst()
                        .ifPresent(pageableParameter -> {
                            operation.getParameters().remove(pageableParameter);

                            operation.addParametersItem(
                                    new Parameter()
                                            .in(ParameterIn.QUERY.toString())
                                            .name("page")
                                            .schema(new Schema<Integer>()._default(0).type("integer"))
                                            .description("Número da página desejada (começa em 0)."));

                            operation.addParametersItem(
                                    new Parameter()
                                            .in(ParameterIn.QUERY.toString())
                                            .name("size")
                                            .schema(new Schema<Integer>()._default(10).type("integer"))
                                            .description("Tamanho da página."));

                            operation.addParametersItem(
                                    new Parameter()
                                            .in(ParameterIn.QUERY.toString())
                                            .name("sort")
                                            .schema(new Schema<String>().type("string"))
                                            .description("Ordenação dos resultados no formato: campo,asc|desc. Ex: nome,asc. Múltiplos campos: nome,asc&sort=email,desc"));
                        });
            }
        }));
    }
}

