package com.rp.info.controle_manutencao.repository;

import com.rp.info.controle_manutencao.entity.Cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNomeContainingIgnoreCase(String nome);
}
