package com.junior_dev_starter.tarefa12.services;

import com.junior_dev_starter.tarefa12.dtos.ClienteRequestDTO;
import com.junior_dev_starter.tarefa12.dtos.ClienteResponseDTO;
import com.junior_dev_starter.tarefa12.exceptions.ClienteNotFoundException;
import com.junior_dev_starter.tarefa12.mappers.ClienteMapper;
import com.junior_dev_starter.tarefa12.models.Cliente;
import com.junior_dev_starter.tarefa12.repositories.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testes para ClienteService")
class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ClienteMapper clienteMapper;

    @InjectMocks
    private ClienteService clienteService;

    private ClienteRequestDTO clienteRequestDTO;
    private Cliente cliente;
    private ClienteResponseDTO clienteResponseDTO;

    @BeforeEach
    void setUp() {
        clienteRequestDTO = new ClienteRequestDTO();
        clienteRequestDTO.setNome("João Silva");
        clienteRequestDTO.setEmail("joao.silva@email.com");

        cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("João Silva");
        cliente.setEmail("joao.silva@email.com");

        clienteResponseDTO = new ClienteResponseDTO(1L, "João Silva", "joao.silva@email.com");
    }

    @Test
    @DisplayName("Deve lançar IllegalArgumentException ao tentar salvar cliente com email já cadastrado")
    void deveLancarIllegalArgumentExceptionQuandoEmailJaExiste() {
        when(clienteRepository.existsByEmail(clienteRequestDTO.getEmail())).thenReturn(true);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                clienteService.salvar(clienteRequestDTO)
        );

        assertEquals("Email já cadastrado: " + clienteRequestDTO.getEmail(), exception.getMessage());
        verify(clienteRepository, never()).save(any());
        verify(clienteMapper, never()).toEntity(any());
    }

    @Test
    @DisplayName("Deve retornar página vazia quando nome for nulo ou vazio")
    void deveRetornarPaginaVaziaQuandoNomeForNuloOuVazio() {
        Pageable pageable = PageRequest.of(0, 10);

        Page<ClienteResponseDTO> resultadoNulo = clienteService.buscarClientesPorNomePaginado(null, pageable);
        Page<ClienteResponseDTO> resultadoVazio = clienteService.buscarClientesPorNomePaginado("   ", pageable);

        assertTrue(resultadoNulo.isEmpty());
        assertTrue(resultadoVazio.isEmpty());
        verify(clienteRepository, never()).findByNomeContainingIgnoreCase(any(), any());
    }

    @Test
    @DisplayName("Deve retornar página vazia quando nenhum cliente encontrado por nome")
    void deveRetornarPaginaVaziaQuandoNenhumClienteEncontradoPorNome() {
        Pageable pageable = PageRequest.of(0, 10);
        when(clienteRepository.findByNomeContainingIgnoreCase("Maria", pageable))
                .thenReturn(Page.empty(pageable));

        Page<ClienteResponseDTO> resultado = clienteService.buscarClientesPorNomePaginado("Maria", pageable);

        assertTrue(resultado.isEmpty());
        verify(clienteRepository).findByNomeContainingIgnoreCase("Maria", pageable);
        verify(clienteMapper, never()).toDTO(any());
    }

    @Test
    @DisplayName("Deve lançar ClienteNotFoundException quando cliente não encontrado para atualização")
    void deveLancarExcecaoQuandoClienteNaoEncontradoNaAtualizacao() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        ClienteNotFoundException exception = assertThrows(ClienteNotFoundException.class, () ->
                clienteService.atualizar(1L, clienteRequestDTO)
        );

        assertEquals("Cliente com id: 1 não encontrado.", exception.getMessage());
        verify(clienteRepository, never()).save(any());
    }

    @Test
    @DisplayName("Deve lançar IllegalArgumentException quando email duplicado na atualização")
    void deveLancarIllegalArgumentExceptionQuandoEmailDuplicadoNaAtualizacao() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        when(clienteRepository.existsByEmail(clienteRequestDTO.getEmail())).thenReturn(true);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                clienteService.atualizar(1L, clienteRequestDTO)
        );

        assertEquals("Email já cadastrado: " + clienteRequestDTO.getEmail(), exception.getMessage());
        verify(clienteRepository, never()).save(any());
    }

    @Test
    @DisplayName("Deve salvar cliente com sucesso quando dados válidos são fornecidos")
    void deveSalvarClienteComSucesso() {
        when(clienteRepository.existsByEmail(clienteRequestDTO.getEmail())).thenReturn(false);
        when(clienteMapper.toEntity(clienteRequestDTO)).thenReturn(cliente);
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);
        when(clienteMapper.toDTO(any(Cliente.class))).thenReturn(clienteResponseDTO);

        ClienteResponseDTO resultado = clienteService.salvar(clienteRequestDTO);

        assertAll(
                () -> assertNotNull(resultado),
                () -> assertEquals("João Silva", resultado.getNome()),
                () -> assertEquals("joao.silva@email.com", resultado.getEmail())
        );

        verify(clienteRepository).save(any(Cliente.class));
        verify(clienteMapper).toEntity(clienteRequestDTO);
        verify(clienteMapper).toDTO(any());
    }

    @Test
    @DisplayName("Deve remover cliente quando encontrado")
    void deveRemoverClienteQuandoEncontrado() {
        // Arrange
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        when(clienteMapper.toDTO(cliente)).thenReturn(clienteResponseDTO);

        // Act
        ClienteResponseDTO resultado = clienteService.remover(1L);

        // Assert
        assertAll(
                () -> assertNotNull(resultado),
                () -> assertEquals(1L, resultado.getId()),
                () -> assertEquals("João Silva", resultado.getNome()),
                () -> assertEquals("joao.silva@email.com", resultado.getEmail())
        );

        verify(clienteRepository).findById(1L);
        verify(clienteRepository).delete(cliente);
        verify(clienteMapper).toDTO(cliente);
    }

    @Test
    @DisplayName("Deve lançar ClienteNotFoundException ao tentar remover cliente inexistente")
    void deveLancarExcecaoAoRemoverClienteInexistente() {
        // Arrange
        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        ClienteNotFoundException exception = assertThrows(ClienteNotFoundException.class, () ->
                clienteService.remover(1L)
        );

        assertEquals("Cliente com id: 1 não encontrado.", exception.getMessage());
        verify(clienteRepository, never()).delete(any());
    }
}