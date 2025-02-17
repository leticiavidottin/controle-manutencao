package com.rp.info.controle_manutencao.repository;

import com.rp.info.controle_manutencao.entity.Cliente;
import com.rp.info.controle_manutencao.entity.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
    List<OrdemServico> findByCliente(Cliente cliente);
}
