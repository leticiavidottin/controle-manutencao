package com.rp.info.controle_manutencao.dto;

import com.rp.info.controle_manutencao.entity.Acompanhamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcompanhamentoDto {
    private Long id;
    private String descricao;
    private LocalDate dataRegistro;

    public static AcompanhamentoDto fromEntity(Acompanhamento acompanhamento) {
        return new AcompanhamentoDto(
            acompanhamento.getId(),
            acompanhamento.getDescricao(),
            acompanhamento.getDataRegistro()
        );
    }

    public Acompanhamento toEntity() {
        Acompanhamento acompanhamento = new Acompanhamento();
        acompanhamento.setId(this.id);
        acompanhamento.setDescricao(this.descricao);
        acompanhamento.setDataRegistro(this.dataRegistro);
        return acompanhamento;
    }
}
