package com.junior_dev_starter.tarefa09.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
        .info(new Info()
        .title("API de Clientes")
        .description("Documentação dos Endpoints da API de Clientes, utilizando o Swagger")
        .version("1.0.0"));
    }
}