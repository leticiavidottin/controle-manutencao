package com.rp.info.controle_manutencao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rp.info.controle_manutencao.entity.OrdemServico;
import com.rp.info.controle_manutencao.entity.Servico;
import com.rp.info.controle_manutencao.service.OrdemServicoService;

import java.util.List;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @PostMapping
    public ResponseEntity<OrdemServico> criarOrdemServico(@RequestBody OrdemServico ordemServico) {
        OrdemServico novaOrdem = ordemServicoService.criarOrdemServico(ordemServico);
        return ResponseEntity.ok(novaOrdem);
    }

    @GetMapping("/pendentes")
    public ResponseEntity<List<OrdemServico>> listarOrdensPendentes() {
        List<OrdemServico> ordensPendentes = ordemServicoService.listarOrdensPendentes();
        return ResponseEntity.ok(ordensPendentes);
    }

    @PutMapping("/{id}/servico")
    public ResponseEntity<Servico> registrarServico(@PathVariable Long id, @RequestBody Servico servico) {
        Servico servicoAtualizado = ordemServicoService.registrarServico(id, servico);
        return ResponseEntity.ok(servicoAtualizado);
    }
}