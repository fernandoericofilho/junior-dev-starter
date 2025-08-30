package br.com.lucaskevin.tarefa_09.service;

import br.com.lucaskevin.tarefa_09.dto.ClienteRequestDTO;
import br.com.lucaskevin.tarefa_09.dto.ClienteResponseDTO;
import br.com.lucaskevin.tarefa_09.exception.ClienteNotFoundException;
import br.com.lucaskevin.tarefa_09.mapper.ClienteMapper;
import br.com.lucaskevin.tarefa_09.model.Cliente;
import br.com.lucaskevin.tarefa_09.repository.ClienteRepository;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


class ClienteServiceTest {


    @Test
    void deveSalvarClienteComSucesso() {

        ClienteRepository repositoryMock = Mockito.mock(ClienteRepository.class);
        ClienteMapper mapperMock = Mockito.mock(ClienteMapper.class);
        ClienteService clienteService = new ClienteService(repositoryMock, mapperMock);


        ClienteRequestDTO requestDTO = new ClienteRequestDTO();
        requestDTO.setNome("Cliente Teste");
        requestDTO.setEmail("teste@email.com");


        Cliente clienteParaSalvar = new Cliente();
        clienteParaSalvar.setNome("Cliente Teste");
        clienteParaSalvar.setEmail("teste@email.com");

        Cliente clienteSalvo = new Cliente();
        clienteSalvo.setId(1L);
        clienteSalvo.setNome("Cliente Teste");
        clienteSalvo.setEmail("teste@email.com");

        ClienteResponseDTO responseDTOEsperado = new ClienteResponseDTO(1L, "Cliente Teste", "teste@email.com");


        when(repositoryMock.existsByEmail(requestDTO.getEmail())).thenReturn(false);
        when(mapperMock.toEntity(any(ClienteRequestDTO.class))).thenReturn(clienteParaSalvar);
        when(repositoryMock.save(any(Cliente.class))).thenReturn(clienteSalvo);
        when(mapperMock.toDTO(any(Cliente.class))).thenReturn(responseDTOEsperado);


        ClienteResponseDTO resultado = clienteService.salvar(requestDTO);


        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Cliente Teste", resultado.getNome());
    }


    @Test
    void deveLancarExcecaoAoSalvarComEmailDuplicado() {

        ClienteRepository repositoryMock = Mockito.mock(ClienteRepository.class);
        ClienteMapper mapperMock = Mockito.mock(ClienteMapper.class);
        ClienteService clienteService = new ClienteService(repositoryMock, mapperMock);

        ClienteRequestDTO requestDTO = new ClienteRequestDTO();
        requestDTO.setEmail("existente@email.com");


        when(repositoryMock.existsByEmail("existente@email.com")).thenReturn(true);


        assertThrows(IllegalArgumentException.class, () -> {
            clienteService.salvar(requestDTO);
        });
    }


    @Test
    void deveBuscarClientePorIdComSucesso() {

        ClienteRepository repositoryMock = Mockito.mock(ClienteRepository.class);
        ClienteMapper mapperMock = Mockito.mock(ClienteMapper.class);
        ClienteService clienteService = new ClienteService(repositoryMock, mapperMock);

        Long idExistente = 1L;
        Cliente clienteDoBanco = new Cliente();
        clienteDoBanco.setId(idExistente);
        clienteDoBanco.setNome("Cliente Encontrado");
        clienteDoBanco.setEmail("encontrado@email.com");

        ClienteResponseDTO responseDTOEsperado = new ClienteResponseDTO(idExistente, "Cliente Encontrado", "encontrado@email.com");


        when(repositoryMock.findById(idExistente)).thenReturn(Optional.of(clienteDoBanco));
        when(mapperMock.toDTO(clienteDoBanco)).thenReturn(responseDTOEsperado);


        ClienteResponseDTO resultado = clienteService.buscarPorId(idExistente);


        assertNotNull(resultado);
        assertEquals(idExistente, resultado.getId());
    }


    @Test
    void deveLancarExcecaoAoBuscarIdInexistente() {

        ClienteRepository repositoryMock = Mockito.mock(ClienteRepository.class);
        ClienteMapper mapperMock = Mockito.mock(ClienteMapper.class);
        ClienteService clienteService = new ClienteService(repositoryMock, mapperMock);

        Long idInexistente = 99L;


        when(repositoryMock.findById(idInexistente)).thenReturn(Optional.empty());


        assertThrows(ClienteNotFoundException.class, () -> {
            clienteService.buscarPorId(idInexistente);
        });
    }
}