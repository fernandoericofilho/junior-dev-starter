package com.example.springdatajpa.service;

import com.example.springdatajpa.dto.ClienteRequestDTO;
import com.example.springdatajpa.dto.ClienteResponseDTO;
import com.example.springdatajpa.exception.ClienteNotFoundException;
import com.example.springdatajpa.mapper.ClienteMapper;
import com.example.springdatajpa.model.Cliente;
import com.example.springdatajpa.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteServiceTest {

    @Test
    void deveSalvarClienteComSucesso() {
        //Arrange
        ClienteRepository repositoryMock = Mockito.mock(ClienteRepository.class);
        ClienteMapper mapperMock = Mockito.mock(ClienteMapper.class);

        ClienteService service = new ClienteService(repositoryMock, mapperMock);

        ClienteRequestDTO requestDTO = new ClienteRequestDTO("Cliente Teste", "teste@email.com");
        Cliente clienteParaSalvar = new Cliente("Cliente Teste", "teste@email.com");
        Cliente clienteSalvo = new Cliente("Cliente Teste", "teste@email.com");
        clienteSalvo.setId(1L);
        ClienteResponseDTO expectedResponse = new ClienteResponseDTO(1L, "Cliente Teste", "teste@email.com");

        Mockito.when(mapperMock.toEntity(requestDTO)).thenReturn(clienteParaSalvar);
        Mockito.when(repositoryMock.save(clienteParaSalvar)).thenReturn(clienteSalvo);
        Mockito.when(mapperMock.toDTO(clienteSalvo)).thenReturn(expectedResponse);

        //Act
        ClienteResponseDTO actualResponse = service.salvar(requestDTO);

        //Assert
        assertNotNull(actualResponse);
        assertEquals(expectedResponse.getId(), actualResponse.getId());
        assertEquals(expectedResponse.getNome(), actualResponse.getNome());

    }

    @Test
    void deveLancarExcecaoAoBuscarClienteInexistente() {
        //Arrange
        ClienteRepository repositoryMock = Mockito.mock(ClienteRepository.class);
        ClienteMapper mapperMock = Mockito.mock(ClienteMapper.class);
        ClienteService service = new ClienteService(repositoryMock, mapperMock);
        Long idInexistente = 99L;

        Mockito.when(repositoryMock.findById(idInexistente)).thenReturn(Optional.empty());

        //Act e Assert
        assertThrows(ClienteNotFoundException.class, () -> {
            service.buscarPorId(idInexistente);
        });

    }
}
