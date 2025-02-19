package com.rp.info.controle_manutencao.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Data
public class OrdemServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "equipamento_id", nullable = false)
    private Equipamento equipamento;

    private String status;
    private LocalDate dataAbertura;
    private LocalDate dataTermino;

    @OneToMany(mappedBy = "ordemServico", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Servico> servicos;

    @OneToMany(mappedBy = "ordemServico", cascade = CascadeType.ALL)
    private List<Acompanhamento> acompanhamentos;
}
