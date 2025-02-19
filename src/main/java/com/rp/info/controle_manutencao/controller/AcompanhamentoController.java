package com.rp.info.controle_manutencao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import com.rp.info.controle_manutencao.entity.Acompanhamento;
import com.rp.info.controle_manutencao.service.AcompanhamentoService;

@RestController
@RequestMapping("/acompanhamentos")
public class AcompanhamentoController {

    @Autowired
    private AcompanhamentoService acompanhamentoService;

    @PostMapping
    public ResponseEntity<Acompanhamento> criarAcompanhamento(@RequestBody Acompanhamento acompanhamento) {
        Acompanhamento novoAcompanhamento = acompanhamentoService.criarAcompanhamento(acompanhamento);
        return ResponseEntity.ok(novoAcompanhamento);
    }

    @GetMapping
    public ResponseEntity<List<Acompanhamento>> listarAcompanhamentos() {
        List<Acompanhamento> acompanhamentos = acompanhamentoService.listarAcompanhamentos();
        return ResponseEntity.ok(acompanhamentos);
    }
}
