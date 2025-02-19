package com.rp.info.controle_manutencao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rp.info.controle_manutencao.dto.AcompanhamentoDto;
import com.rp.info.controle_manutencao.dto.DadosCriacaoOrdemServicoDto;
import com.rp.info.controle_manutencao.dto.ServicoDto;
import com.rp.info.controle_manutencao.entity.Acompanhamento;
import com.rp.info.controle_manutencao.entity.Cliente;
import com.rp.info.controle_manutencao.entity.Equipamento;
import com.rp.info.controle_manutencao.entity.OrdemServico;
import com.rp.info.controle_manutencao.entity.Servico;
import com.rp.info.controle_manutencao.repository.AcompanhamentoRepository;
import com.rp.info.controle_manutencao.repository.ClienteRepository;
import com.rp.info.controle_manutencao.repository.EquipamentoRepository;
import com.rp.info.controle_manutencao.repository.OrdemServicoRepository;
import com.rp.info.controle_manutencao.repository.ServicoRepository;

import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private AcompanhamentoRepository acompanhamentoRepository;

    @Transactional
    public ResponseEntity<OrdemServico> criarOrdemServico(DadosCriacaoOrdemServicoDto dados) {
        if (dados.getClienteId() == null || dados.getEquipamentoId() == null) {
            throw new IllegalArgumentException("ID do Cliente e do Equipamento são obrigatórios. \n");
        }
        
        OrdemServico ordemServico = new OrdemServico();
        ordemServico.setDataAbertura(LocalDate.now());
    
        Cliente cliente = clienteRepository.findById(dados.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        Equipamento equipamento = equipamentoRepository.findById(dados.getEquipamentoId())
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));
    
        ordemServico.setCliente(cliente);
        ordemServico.setEquipamento(equipamento);
        ordemServico.setStatus("PENDENTE");
    
        ordemServico = ordemServicoRepository.save(ordemServico);
    
        if (dados.getServicos() != null) {
            for (ServicoDto servicoDto : dados.getServicos()) {
                Servico servico = new Servico();
                servico.setDescricao(servicoDto.getDescricao());
                servico.setDataInicio(servicoDto.getDataInicio());
                servico.setDataTermino(servicoDto.getDataTermino());
                servico.setOrdemServico(ordemServico);
                servicoRepository.save(servico);
            }
        }
    
        if (dados.getAcompanhamentos() != null) {
            for (AcompanhamentoDto acompanhamentoDto : dados.getAcompanhamentos()) {
                Acompanhamento acompanhamento = new Acompanhamento();
                acompanhamento.setDescricao(acompanhamentoDto.getDescricao());
                acompanhamento.setDataRegistro(LocalDate.now());
                acompanhamento.setOrdemServico(ordemServico);
                acompanhamentoRepository.save(acompanhamento);
            }
        }
    
        return ResponseEntity.ok(ordemServico);
    }    

    public List<OrdemServico> listarOrdensPendentes() {
        return ordemServicoRepository.findByStatus("PENDENTE");
    }

    public List<OrdemServico> listarOrdensServico() {
        return ordemServicoRepository.findAll();
    }

    public OrdemServico finalizarServico(Long ordemServicoId) {
        Optional<OrdemServico> ordemServicoOpt = ordemServicoRepository.findById(ordemServicoId);
        
        if (ordemServicoOpt.isPresent()) {
            OrdemServico ordemServico = ordemServicoOpt.get();
            ordemServico.setStatus("CONCLUIDO");
    
            if (ordemServico.getDataTermino() == null) {
                ordemServico.setDataTermino(LocalDate.now());
            }
    
            return ordemServicoRepository.save(ordemServico); 
        }
        
        throw new RuntimeException("Ordem de serviço não encontrada");
    }
    
}
