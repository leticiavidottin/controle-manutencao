package com.rp.info.controle_manutencao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rp.info.controle_manutencao.entity.Acompanhamento;
import com.rp.info.controle_manutencao.repository.AcompanhamentoRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class AcompanhamentoService {

    @Autowired
    private AcompanhamentoRepository acompanhamentoRepository;

    public Acompanhamento criarAcompanhamento(Acompanhamento acompanhamento) {
        acompanhamento.setDataRegistro(LocalDate.now());
        return acompanhamentoRepository.save(acompanhamento);
    }

    public List<Acompanhamento> listarAcompanhamentos() {
        return acompanhamentoRepository.findAll();
    }
}
