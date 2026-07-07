package com.Ronald.Categorizador.dto.Request;

import org.antlr.v4.runtime.misc.NotNull;

public record EventoRequestDTO(
        @NotNull String nome,
        String descricao,
        String dataEvento
) {
}
