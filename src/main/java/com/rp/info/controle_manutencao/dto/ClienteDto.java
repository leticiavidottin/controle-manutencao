package com.rp.info.controle_manutencao.dto;

import com.rp.info.controle_manutencao.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private List<EquipamentoDto> equipamentos;

    public static ClienteDto fromEntity(Cliente cliente) {
        return new ClienteDto(
            cliente.getId(),
            cliente.getNome(),
            cliente.getEndereco(),
            cliente.getTelefone(),
            cliente.getEmail(),
            cliente.getEquipamentos() != null ? 
                cliente.getEquipamentos().stream()
                    .map(EquipamentoDto::fromEntity)
                    .collect(Collectors.toList()) : null
        );
    }

    public Cliente toEntity() {
        Cliente cliente = new Cliente();
        cliente.setId(this.id);
        cliente.setNome(this.nome);
        cliente.setEndereco(this.endereco);
        cliente.setTelefone(this.telefone);
        cliente.setEmail(this.email);

        if (this.equipamentos != null) {
            cliente.setEquipamentos(this.equipamentos.stream()
                .map(EquipamentoDto::toEntity)
                .collect(Collectors.toList()));
        }

        return cliente;
    }
}
