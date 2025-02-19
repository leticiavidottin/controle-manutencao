package com.rp.info.controle_manutencao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rp.info.controle_manutencao.entity.Equipamento;
import com.rp.info.controle_manutencao.repository.EquipamentoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    public Equipamento create(Equipamento equipamento) {
        return equipamentoRepository.save(equipamento);
    }

    public List<Equipamento> getAll() {
        return equipamentoRepository.findAll();
    }

    public Optional<Equipamento> getById(Long id) {
        return equipamentoRepository.findById(id);
    }

    public Equipamento update(Long id, Equipamento equipamentoAtualizado) {
        return equipamentoRepository.findById(id).map(equipamento -> {
            equipamento.setDescricao(equipamentoAtualizado.getDescricao());
            equipamento.setMarca(equipamentoAtualizado.getMarca());
            equipamento.setTipo(equipamentoAtualizado.getTipo());
            return equipamentoRepository.save(equipamento);
        }).orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));
    }

    public void delete(Long id) {
        equipamentoRepository.deleteById(id);
    }
}
