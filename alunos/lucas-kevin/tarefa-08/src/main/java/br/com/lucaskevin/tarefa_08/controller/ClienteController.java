package br.com.lucaskevin.tarefa_08.controller;

import br.com.lucaskevin.tarefa_08.model.Cliente;
import br.com.lucaskevin.tarefa_08.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // --- ENDPOINTS ---

    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    // PONTO MAIS IMPORTANTE: GARANTA QUE ESTA ANOTAÇÃO ESTÁ AQUI
    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) {
        return clienteService.salvar(cliente);
    }
}