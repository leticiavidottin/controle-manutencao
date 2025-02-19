package com.rp.info.controle_manutencao.controller;

import com.rp.info.controle_manutencao.entity.Cliente;
import com.rp.info.controle_manutencao.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public Cliente buscarClientePorId(@PathVariable Long id) {
        return clienteService.buscarClientePorId(id);
    }

    @GetMapping("/buscar")
    public List<Cliente> buscarPorNome(@RequestParam String nome) {
        return clienteService.buscarPorNome(nome);
    }

    @PostMapping
    public Cliente salvarCliente(@RequestBody Cliente cliente) {
        return clienteService.salvarCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public String excluirCliente(@PathVariable Long id) {
        return clienteService.excluirCliente(id) ? "Cliente excluído com sucesso!" : "Cliente não encontrado!";
    }
}
