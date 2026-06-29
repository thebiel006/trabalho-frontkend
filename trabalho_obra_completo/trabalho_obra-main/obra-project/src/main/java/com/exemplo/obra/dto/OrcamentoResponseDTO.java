package com.exemplo.obra.dto;

import com.exemplo.obra.entity.Orcamento;

public record OrcamentoResponseDTO(
        Long id,
        String numero,
        String nomeCliente,
        double areaTotal,
        double volumeConcreto,
        int quantidadeTijolos,
        double custoMateriais,
        double margemLucro,
        double valorLucro,
        double valorFinal
) {
    public static OrcamentoResponseDTO from(Orcamento o) {
        return new OrcamentoResponseDTO(o.getId(), o.getNumero(), o.getNomeCliente(), o.getAreaTotal(),
                o.getVolumeConcreto(), o.getQuantidadeTijolos(), o.getCustoMateriais(), o.getMargemLucro(),
                o.getValorLucro(), o.getValorFinal());
    }
}
