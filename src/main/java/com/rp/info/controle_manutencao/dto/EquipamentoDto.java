package com.rp.info.controle_manutencao.dto;

import com.rp.info.controle_manutencao.entity.Equipamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipamentoDto {
    private Long id;
    private String tipo;
    private String marca;
    private String descricao;

    public static EquipamentoDto fromEntity(Equipamento equipamento) {
        return new EquipamentoDto(
            equipamento.getId(),
            equipamento.getTipo(),
            equipamento.getMarca(),
            equipamento.getDescricao()
        );
    }

    public Equipamento toEntity() {
        Equipamento equipamento = new Equipamento();
        equipamento.setId(this.id);
        equipamento.setTipo(this.tipo);
        equipamento.setMarca(this.marca);
        equipamento.setDescricao(this.descricao);
        return equipamento;
    }    
}
