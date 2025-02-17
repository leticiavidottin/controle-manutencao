package com.rp.info.controle_manutencao.repository;

import com.rp.info.controle_manutencao.entity.Acompanhamento;
import com.rp.info.controle_manutencao.entity.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcompanhamentoRepository extends JpaRepository<Acompanhamento, Long> {
    List<Acompanhamento> findByOrdemServico(OrdemServico ordemServico);
}
