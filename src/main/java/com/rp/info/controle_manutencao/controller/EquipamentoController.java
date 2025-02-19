package com.rp.info.controle_manutencao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rp.info.controle_manutencao.entity.Equipamento;
import com.rp.info.controle_manutencao.service.EquipamentoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;

    @PostMapping
    public ResponseEntity<Equipamento> create(@RequestBody Equipamento equipamento) {
        return ResponseEntity.ok(equipamentoService.create(equipamento));
    }

    @GetMapping
    public ResponseEntity<List<Equipamento>> getAll() {
        return ResponseEntity.ok(equipamentoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipamento> getById(@PathVariable Long id) {
        Optional<Equipamento> equipamento = equipamentoService.getById(id);
        return equipamento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipamento> update(@PathVariable Long id, @RequestBody Equipamento equipamento) {
        try {
            return ResponseEntity.ok(equipamentoService.update(id, equipamento));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        equipamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
