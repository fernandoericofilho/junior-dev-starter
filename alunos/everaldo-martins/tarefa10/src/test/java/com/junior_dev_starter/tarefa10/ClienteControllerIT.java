package com.junior_dev_starter.tarefa10;

import com.junior_dev_starter.tarefa10.models.Cliente;
import com.junior_dev_starter.tarefa10.repositories.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
public class ClienteControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClienteRepository clienteRepository;

    private Cliente clienteSalvo;

    @BeforeEach
    void setUp() {
        clienteRepository.deleteAll();
        clienteSalvo = new Cliente();
        clienteSalvo.setNome("Fulano de Tal");
        clienteSalvo.setEmail("fulano@teste.com");

        clienteSalvo = clienteRepository.save(clienteSalvo);
    }

    @Test
    void deveCriarClienteComSucesso() throws Exception {
        String json = """
                {
                    "nome": "Maria Silva",
                    "email": "maria@teste.com"
                }
                """;

        mockMvc.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print()) // Adicione esta linha para depuração
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.nome").value("Maria Silva"))
                .andExpect(jsonPath("$.email").value("maria@teste.com"));
    }

    @Test
    void deveRetornarErroAoCriarClienteComEmailInvalido() throws Exception {
        String json = """
                {
                    "nome": "João Silva",
                    "email": "email_invalido"
                }
                """;

        mockMvc.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    void deveBuscarClientePorId() throws Exception {
        mockMvc.perform(get("/clientes/{id}", clienteSalvo.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(clienteSalvo.getId()))
                .andExpect(jsonPath("$.nome").value(clienteSalvo.getNome()))
                .andExpect(jsonPath("$.email").value(clienteSalvo.getEmail()));
    }

    @Test
    void deveRetornarNotFoundParaClienteInexistente() throws Exception {
        Long idInexistente = 999L;
        mockMvc.perform(get("/clientes/{id}", idInexistente))
                .andExpect(status().isNotFound());
    }

    @Test
    void deveAtualizarCliente() throws Exception {
        String jsonUpdate = """
                {
                    "nome": "Nome Atualizado",
                    "email": "atualizado@email.com"
                }
                """;

        mockMvc.perform(put("/clientes/{id}", clienteSalvo.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonUpdate))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(clienteSalvo.getId()))
                .andExpect(jsonPath("$.nome").value("Nome Atualizado"))
                .andExpect(jsonPath("$.email").value("atualizado@email.com"));
    }

    @Test
    void deveBuscarClientesPorNome() throws Exception {

        mockMvc.perform(get("/clientes/nome/{nome}", "Fulano"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.clienteResponseDTOList").isArray())
                .andExpect(jsonPath("$._embedded.clienteResponseDTOList[0].nome").value("Fulano de Tal"))
                .andExpect(jsonPath("$._embedded.clienteResponseDTOList[0].email").value("fulano@teste.com"))
                .andExpect(jsonPath("$._links.self.href").exists());
    }

    @Test
    void listagemDeveConterLinksHateoas() throws Exception {
        mockMvc.perform(get("/clientes?page=0&size=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.clienteResponseDTOList").isArray())
                .andExpect(jsonPath("$._links.self.href").exists())
                .andExpect(jsonPath("$._embedded.clienteResponseDTOList[0]._links.self.href").exists())
                .andExpect(jsonPath("$._embedded.clienteResponseDTOList[0]._links.update.href").exists())
                .andExpect(jsonPath("$._embedded.clienteResponseDTOList[0]._links.delete.href").exists())
                .andExpect(jsonPath("$._embedded.clienteResponseDTOList[0]._links.all.href").exists());
    }

    @Test
    void deveDeletarCliente() throws Exception {
        mockMvc.perform(delete("/clientes/{id}", clienteSalvo.getId()))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/clientes/{id}", clienteSalvo.getId()))
                .andExpect(status().isNotFound());
    }
}