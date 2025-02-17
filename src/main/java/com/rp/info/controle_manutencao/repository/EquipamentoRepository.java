package com.rp.info.controle_manutencao.repository;

import com.rp.info.controle_manutencao.entity.Cliente;
import com.rp.info.controle_manutencao.entity.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
    List<Equipamento> findByCliente(Cliente cliente);
}
