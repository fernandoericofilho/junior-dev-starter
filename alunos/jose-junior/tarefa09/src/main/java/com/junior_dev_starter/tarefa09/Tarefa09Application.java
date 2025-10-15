package com.junior_dev_starter.tarefa09;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
	info = @Info(
		title = "API de Clientes",
		version = "1",
		description = "API desenvolvida para a resolução da tarefa 09"
	)
)
public class Tarefa09Application {
	public static void main(String[] args) {
		SpringApplication.run(Tarefa09Application.class, args);
	}

}