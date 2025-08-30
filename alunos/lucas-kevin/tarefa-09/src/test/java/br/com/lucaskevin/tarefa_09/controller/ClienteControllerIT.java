package br.com.lucaskevin.tarefa_09.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
class ClienteControllerIT {


    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveCriarEListarClienteComSucesso() throws Exception {

        String novoClienteJson = """
            {
                "nome": "Maria Integracao",
                "email": "maria.it@teste.com"
            }
        """;


        mockMvc.perform(MockMvcRequestBuilders.post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(novoClienteJson))
                .andExpect(MockMvcResultMatchers.status().isCreated());



        mockMvc.perform(MockMvcRequestBuilders.get("/clientes?page=0&size=5&sort=nome,asc"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[?(@.nome == 'Maria Integracao')]").exists());
    }
}