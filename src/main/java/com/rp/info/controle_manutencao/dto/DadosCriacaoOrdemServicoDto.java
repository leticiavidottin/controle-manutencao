package com.rp.info.controle_manutencao.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosCriacaoOrdemServicoDto {
    private ClienteDto cliente; 
    private EquipamentoDto equipamento; 
    
    private List<ServicoDto> servicos; 
    private List<AcompanhamentoDto> acompanhamentos; 

    public Long getClienteId() {
        return cliente != null ? cliente.getId() : null;
    }

    public Long getEquipamentoId() {
        return equipamento != null ? equipamento.getId() : null;
    }
}
