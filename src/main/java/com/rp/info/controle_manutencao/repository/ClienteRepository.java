package com.rp.info.controle_manutencao.repository;

import com.rp.info.controle_manutencao.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
