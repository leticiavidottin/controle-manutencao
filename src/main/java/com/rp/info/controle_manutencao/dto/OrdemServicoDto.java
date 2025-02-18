package com.rp.info.controle_manutencao.dto;

import com.rp.info.controle_manutencao.entity.OrdemServico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdemServicoDto {
    private Long id;
    private String status;
    private LocalDate dataAbertura;
    private List<ServicoDto> servicos;
    private List<AcompanhamentoDto> acompanhamentos;

    public static OrdemServicoDto fromEntity(OrdemServico ordemServico) {
        return new OrdemServicoDto(
            ordemServico.getId(),
            ordemServico.getStatus(),
            ordemServico.getDataAbertura(),
            ordemServico.getServicos() != null ? 
                ordemServico.getServicos().stream()
                    .map(ServicoDto::fromEntity)
                    .collect(Collectors.toList()) : null,
            ordemServico.getAcompanhamentos() != null ?
                ordemServico.getAcompanhamentos().stream()
                    .map(AcompanhamentoDto::fromEntity)
                    .collect(Collectors.toList()) : null
        );
    }

    public OrdemServico toEntity() {
        OrdemServico ordemServico = new OrdemServico();
        ordemServico.setId(this.id);
        ordemServico.setStatus(this.status);
        ordemServico.setDataAbertura(this.dataAbertura);

        if (this.servicos != null) {
            ordemServico.setServicos(this.servicos.stream()
                .map(ServicoDto::toEntity)
                .collect(Collectors.toList()));
        }

        if (this.acompanhamentos != null) {
            ordemServico.setAcompanhamentos(this.acompanhamentos.stream()
                .map(AcompanhamentoDto::toEntity)
                .collect(Collectors.toList()));
        }

        return ordemServico;
    }
}
