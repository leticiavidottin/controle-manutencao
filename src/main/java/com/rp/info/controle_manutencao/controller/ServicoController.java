package com.rp.info.controle_manutencao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rp.info.controle_manutencao.entity.Servico;
import com.rp.info.controle_manutencao.service.ServicoService;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public ResponseEntity<List<Servico>> listarServicos() {
        List<Servico> servicos = servicoService.listarServicos();
        return ResponseEntity.ok(servicos);
    }
}
