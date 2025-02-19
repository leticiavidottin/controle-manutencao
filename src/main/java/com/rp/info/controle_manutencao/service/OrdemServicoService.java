package com.rp.info.controle_manutencao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rp.info.controle_manutencao.entity.OrdemServico;
import com.rp.info.controle_manutencao.entity.Servico;
import com.rp.info.controle_manutencao.repository.OrdemServicoRepository;
import com.rp.info.controle_manutencao.repository.ServicoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    public OrdemServico criarOrdemServico(OrdemServico ordemServico) {
        ordemServico.setDataAbertura(LocalDate.now());
        ordemServico.setStatus("PENDENTE");
        return ordemServicoRepository.save(ordemServico);
    }

    public List<OrdemServico> listarOrdensPendentes() {
        return ordemServicoRepository.findByStatus("PENDENTE");
    }

    public Servico registrarServico(Long ordemServicoId, Servico servico) {
        Optional<OrdemServico> ordemServicoOpt = ordemServicoRepository.findById(ordemServicoId);
        if (ordemServicoOpt.isPresent()) {
            OrdemServico ordemServico = ordemServicoOpt.get();
            servico.setOrdemServico(ordemServico);
            if (servico.getDataInicio() == null) {
                servico.setDataInicio(LocalDate.now());
            }
            servico.setDataTermino(LocalDate.now());
            return servicoRepository.save(servico);
        }
        throw new RuntimeException("Ordem de serviço não encontrada");
    }
}
