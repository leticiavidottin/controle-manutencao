package com.rp.info.controle_manutencao.dto;

import com.rp.info.controle_manutencao.entity.Servico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicoDto {
    private Long id;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataTermino;

    public static ServicoDto fromEntity(Servico servico) {
        return new ServicoDto(
            servico.getId(),
            servico.getDescricao(),
            servico.getDataInicio(),
            servico.getDataTermino()
        );
    }

    public Servico toEntity() {
        Servico servico = new Servico();
        servico.setId(this.id);
        servico.setDescricao(this.descricao);
        servico.setDataInicio(this.dataInicio);
        servico.setDataTermino(this.dataTermino);
        return servico;
    }
}
