package com.rp.info.controle_manutencao.repository;

import com.rp.info.controle_manutencao.entity.OrdemServico;
import com.rp.info.controle_manutencao.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
    List<Servico> findByOrdemServico(OrdemServico ordemServico);
}
