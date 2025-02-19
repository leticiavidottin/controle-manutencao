package com.rp.info.controle_manutencao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rp.info.controle_manutencao.dto.DadosCriacaoOrdemServicoDto;
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
    public ResponseEntity<OrdemServico> criarOrdemServico(@RequestBody DadosCriacaoOrdemServicoDto dados) {
        return ordemServicoService.criarOrdemServico(dados);
    }

    @GetMapping
    public ResponseEntity<List<OrdemServico>> listarOrdensServico() {
        List<OrdemServico> ordensServico = ordemServicoService.listarOrdensServico();
        return ResponseEntity.ok(ordensServico);
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