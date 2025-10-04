package com.example.springdatajpa.service;

import com.example.springdatajpa.dto.ClienteRequestDTO;
import com.example.springdatajpa.dto.ClienteResponseDTO;
import com.example.springdatajpa.exception.ClienteNotFoundException;
import com.example.springdatajpa.mapper.ClienteMapper;
import com.example.springdatajpa.model.Cliente;
import com.example.springdatajpa.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ClienteMapper clienteMapper;

    @InjectMocks
    private ClienteService clienteService;

    private Cliente cliente;
    private ClienteRequestDTO requestDTO;
    private ClienteResponseDTO responseDTO;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("Cliente Teste", "teste@email.com");
        cliente.setId(1L);

        requestDTO = new ClienteRequestDTO("Cliente Teste", "teste@email.com");
        responseDTO = new ClienteResponseDTO(1L, "Cliente Teste", "teste@email.com");
    }

    @Test
    void deveSalvarClienteComSucesso() {
        when(clienteRepository.existsByEmail(requestDTO.getEmail())).thenReturn(false);
        when(clienteMapper.toEntity(requestDTO)).thenReturn(cliente);
        when(clienteRepository.save(cliente)).thenReturn(cliente);
        when(clienteMapper.toDTO(cliente)).thenReturn(responseDTO);

        ClienteResponseDTO resultado = clienteService.salvar(requestDTO);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Cliente Teste", resultado.getNome());
        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    void deveLancarExcecaoAoTentarSalvarEmailDuplicado() {
        when(clienteRepository.existsByEmail(requestDTO.getEmail())).thenReturn(true);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            clienteService.salvar(requestDTO);
        });

        assertEquals("Email já cadastrado: " + requestDTO.getEmail(), exception.getMessage());
        verify(clienteRepository, never()).save(any());
    }

    @Test
    void deveBuscarClientePorIdComSucesso() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        when(clienteMapper.toDTO(cliente)).thenReturn(responseDTO);

        ClienteResponseDTO resultado = clienteService.buscarPorId(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Cliente Teste", resultado.getNome());
        verify(clienteRepository, times(1)).findById(1L);
    }

    @Test
    void deveLancarExcecaoAoBuscarClienteInexistente() {
        when(clienteRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ClienteNotFoundException.class, () -> clienteService.buscarPorId(99L));
        verify(clienteRepository, times(1)).findById(99L);
    }

    @Test
    void deveListarTodosOsClientesComPageable() {
        Cliente cliente2 = new Cliente("Cliente 2", "cliente2@email.com");
        cliente2.setId(2L);

        ClienteResponseDTO dto1 = new ClienteResponseDTO(1L, "Cliente Teste", "teste@email.com");
        ClienteResponseDTO dto2 = new ClienteResponseDTO(2L, "Cliente 2", "cliente2@email.com");

        Pageable pageable = PageRequest.of(0, 10);
        Page<Cliente> paginaClientes = new PageImpl<>(List.of(cliente, cliente2), pageable, 2);

        when(clienteRepository.findAll(pageable)).thenReturn(paginaClientes);
        when(clienteMapper.toDTO(cliente)).thenReturn(dto1);
        when(clienteMapper.toDTO(cliente2)).thenReturn(dto2);

        Page<ClienteResponseDTO> resultado = clienteService.listarTodos(pageable);

        assertNotNull(resultado);
        assertEquals(2, resultado.getTotalElements());
        assertEquals("Cliente Teste", resultado.getContent().get(0).getNome());
        assertEquals("Cliente 2", resultado.getContent().get(1).getNome());
        verify(clienteRepository, times(1)).findAll(pageable);
    }

    @Test
    void deveBuscarClientesPorInicial() {
        Cliente cliente2 = new Cliente("Cliente Teste2", "teste2@email.com");
        cliente2.setId(2L);

        ClienteResponseDTO dto1 = new ClienteResponseDTO(1L, "Cliente Teste", "teste@email.com");
        ClienteResponseDTO dto2 = new ClienteResponseDTO(2L, "Cliente Teste2", "teste2@email.com");

        when(clienteRepository.findByNomeLike("Cli%")).thenReturn(List.of(cliente, cliente2));
        when(clienteMapper.toDTO(cliente)).thenReturn(dto1);
        when(clienteMapper.toDTO(cliente2)).thenReturn(dto2);

        List<ClienteResponseDTO> resultado = clienteService.buscaPorInicial("Cli");

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("Cliente Teste", resultado.get(0).getNome());
        assertEquals("Cliente Teste2", resultado.get(1).getNome());
        verify(clienteRepository, times(1)).findByNomeLike("Cli%");
    }
}