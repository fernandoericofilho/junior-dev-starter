package com.example.springdatajpa.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ClienteControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveCriarClienteEListarComSucesso() throws Exception {
        //Arrange
        String clienteJson = """
            {
                "nome": "Cliente de Integração",
                "email": "integracao@teste.com"
            }
        """;

        //Act e Assert
        mockMvc.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(clienteJson))
                .andExpect(status().isCreated());

        //Act e Assert
        mockMvc.perform(get("/clientes?page=0&size=5&sort=nome,asc")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].nome").value("Ana Paula"))
                .andExpect(jsonPath("$.content[1].nome").value("Carlos Silva"))
                .andExpect(jsonPath("$.content[2].nome").value("Cliente de Integração"));
    }

    @Test
    void naoDeveCriarClienteComDadosInvalidos() throws Exception {
        // Arrange
        String clienteInvalidoJson = """
            {
                "nome": "",
                "email": "invalido@teste.com"
            }
        """;

        //Act e Assert
        mockMvc.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(clienteInvalidoJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.nome").value("O nome deve ter entre 3 e 100 caracteres."));
    }
}