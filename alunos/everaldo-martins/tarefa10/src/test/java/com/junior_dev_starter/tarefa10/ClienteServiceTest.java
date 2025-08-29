package com.junior_dev_starter.tarefa10;

import com.junior_dev_starter.tarefa10.dtos.ClienteRequestDTO;
import com.junior_dev_starter.tarefa10.dtos.ClienteResponseDTO;
import com.junior_dev_starter.tarefa10.mappers.ClienteMapper;
import com.junior_dev_starter.tarefa10.models.Cliente;
import com.junior_dev_starter.tarefa10.repositories.ClienteRepository;
import com.junior_dev_starter.tarefa10.services.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.springframework.dao.DataIntegrityViolationException;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testes para ClienteService")
class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ClienteMapper clienteMapper;

    @InjectMocks
    private ClienteService clienteService;

    @Captor
    private ArgumentCaptor<Cliente> clienteCaptor;

    private ClienteRequestDTO clienteRequestDTO;
    private Cliente cliente;

    @BeforeEach
    void setUp() {
        clienteRequestDTO = new ClienteRequestDTO();
        clienteRequestDTO.setNome("João Silva");
        clienteRequestDTO.setEmail("joao.silva@email.com");

        cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("João Silva");
        cliente.setEmail("joao.silva@email.com");
    }

    @Test
    @DisplayName("Deve salvar cliente com sucesso quando dados válidos são fornecidos")
    void deveSalvarClienteComSucesso() {
        when(clienteMapper.toEntity(clienteRequestDTO)).thenReturn(cliente);
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        when(clienteMapper.toDTO(any(Cliente.class))).thenReturn(
                new ClienteResponseDTO(1L, "João Silva", "joao.silva@email.com")
        );

        ClienteResponseDTO clienteSalvo = clienteService.salvar(clienteRequestDTO);

        assertNotNull(clienteSalvo);
        assertNotNull(clienteSalvo.getId());
        assertEquals("João Silva", clienteSalvo.getNome());
        assertEquals("joao.silva@email.com", clienteSalvo.getEmail());

        verify(clienteMapper).toEntity(clienteRequestDTO);
        verify(clienteRepository).save(clienteCaptor.capture());

        Cliente clienteSalvoNoRepository = clienteCaptor.getValue();

        verify(clienteMapper).toDTO(clienteSalvoNoRepository);
        assertEquals("João Silva", clienteSalvoNoRepository.getNome());
    }


    @Test
    @DisplayName("Deve mapear corretamente os campos do DTO para a entidade")
    void deveMapearCorretamenteCamposDoDTO() {
        Cliente clienteMapeado = new Cliente();
        clienteMapeado.setNome(clienteRequestDTO.getNome());
        clienteMapeado.setEmail(clienteRequestDTO.getEmail());

        when(clienteMapper.toEntity(clienteRequestDTO)).thenReturn(clienteMapeado);
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);


        ClienteResponseDTO resultado = clienteService.salvar(clienteRequestDTO);


        verify(clienteMapper).toEntity(clienteRequestDTO);
        assertEquals(clienteRequestDTO.getNome(), clienteMapeado.getNome());
        assertEquals(clienteRequestDTO.getEmail(), clienteMapeado.getEmail());
    }

    @Test
    @DisplayName("Deve chamar o repository.save exatamente uma vez")
    void deveChamarRepositorySaveUmaVez() {
        when(clienteMapper.toEntity(clienteRequestDTO)).thenReturn(cliente);
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        clienteService.salvar(clienteRequestDTO);

        verify(clienteRepository).save(any(Cliente.class));
    }

    @Test
    @DisplayName("Deve lançar exceção ao salvar cliente com email duplicado")
    void deveLancarExcecaoParaEmailDuplicado() {
        when(clienteMapper.toEntity(clienteRequestDTO)).thenReturn(cliente);
        when(clienteRepository.save(any(Cliente.class))).thenThrow(DataIntegrityViolationException.class);

        assertThrows(DataIntegrityViolationException.class, () -> {
            clienteService.salvar(clienteRequestDTO);
        });

        verify(clienteRepository).save(cliente);
    }
}