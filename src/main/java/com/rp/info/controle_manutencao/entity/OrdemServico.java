package com.rp.info.controle_manutencao.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

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

    @OneToMany(mappedBy = "ordemServico", cascade = CascadeType.ALL)
    private List<Servico> servicos;

    @OneToMany(mappedBy = "ordemServico", cascade = CascadeType.ALL)
    private List<Acompanhamento> acompanhamentos;
}
