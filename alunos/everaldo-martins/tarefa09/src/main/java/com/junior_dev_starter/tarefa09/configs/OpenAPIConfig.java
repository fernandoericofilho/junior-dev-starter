package com.junior_dev_starter.tarefa09.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Clientes")
                        .description("Documentação dos endpoints da API de Clientes, com Swagger.")
                        .version("1.0.0"));
    }
}

