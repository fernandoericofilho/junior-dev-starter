package com.example.springdatajpa.controller;

import com.example.springdatajpa.dto.ClienteRequestDTO;
import com.example.springdatajpa.dto.ClienteResponseDTO;
import com.example.springdatajpa.mapper.ClienteMapper;
import com.example.springdatajpa.model.Cliente;
import com.example.springdatajpa.repository.ClienteRepository;
import com.example.springdatajpa.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
    void naoDeveCriarClienteComNomeEmBranco() throws Exception {
        // Arrange: nome em branco -> dispara @NotBlank
        String clienteInvalidoJson = """
        {
            "nome": "",
            "email": "invalido@teste.com"
        }
    """;

        // Act & Assert
        mockMvc.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(clienteInvalidoJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.nome").value("O campo 'nome' é obrigatório e não pode estar em branco."));
    }

    @Test
    void naoDeveCriarClienteComNomeCurto() throws Exception {
        // Arrange: nome com menos de 3 caracteres -> dispara @Size
        String clienteInvalidoJson = """
        {
            "nome": "ab",
            "email": "invalido@teste.com"
        }
    """;

        // Act & Assert
        mockMvc.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(clienteInvalidoJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.nome").value("O nome deve ter entre 3 e 100 caracteres."));
    }

    @Test
    void naoDeveSalvarClienteComEmailDuplicado() {
        // Arrange
        ClienteRepository repositoryMock = Mockito.mock(ClienteRepository.class);
        ClienteMapper mapperMock = Mockito.mock(ClienteMapper.class);
        ClienteService service = new ClienteService(repositoryMock, mapperMock);

        ClienteRequestDTO requestDTO = new ClienteRequestDTO("Duplicado", "teste@email.com");

        // Simula que já existe cliente com esse email
        Mockito.when(repositoryMock.existsByEmail(requestDTO.getEmail())).thenReturn(true);

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            service.salvar(requestDTO);
        });

        assertEquals("Email já cadastrado: teste@email.com", exception.getMessage());
    }

    @Test
    void deveListarClientesComSucesso() {
        // Arrange
        ClienteRepository repositoryMock = Mockito.mock(ClienteRepository.class);
        ClienteMapper mapperMock = new ClienteMapper(); // aqui podemos usar o mapper real
        ClienteService service = new ClienteService(repositoryMock, mapperMock);

        Cliente cliente1 = new Cliente("Carlos", "carlos@email.com");
        cliente1.setId(1L);
        Cliente cliente2 = new Cliente("Ana", "ana@email.com");
        cliente2.setId(2L);

        Pageable pageable = Pageable.ofSize(2);
        Page<Cliente> paginaMock = new org.springframework.data.domain.PageImpl<>(List.of(cliente1, cliente2));

        Mockito.when(repositoryMock.findAll(pageable)).thenReturn(paginaMock);

        // Act
        Page<ClienteResponseDTO> resultado = service.listarTodos(pageable);

        // Assert
        assertEquals(2, resultado.getTotalElements());
        assertEquals("Carlos", resultado.getContent().get(0).getNome());
        assertEquals("Ana", resultado.getContent().get(1).getNome());
    }

    @Test
    void deveBuscarClientesPorPrefixo() {
        // Arrange
        ClienteRepository repositoryMock = Mockito.mock(ClienteRepository.class);
        ClienteMapper mapperMock = new ClienteMapper(); // mapper real
        ClienteService service = new ClienteService(repositoryMock, mapperMock);

        Cliente cliente1 = new Cliente("Pedro", "pedro@email.com");
        cliente1.setId(10L);

        Mockito.when(repositoryMock.findByNomeLike("Pe%")).thenReturn(List.of(cliente1));

        // Act
        List<ClienteResponseDTO> resultado = service.buscaPorInicial("Pe");

        // Assert
        assertEquals(1, resultado.size());
        assertEquals("Pedro", resultado.get(0).getNome());
    }

}