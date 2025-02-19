package com.rp.info.controle_manutencao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rp.info.controle_manutencao.entity.Servico;
import com.rp.info.controle_manutencao.repository.ServicoRepository;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<Servico> listarServicos() {
        return servicoRepository.findAll();
    }
}
