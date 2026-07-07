package com.Ronald.Categorizador.dto.Request;

import org.antlr.v4.runtime.misc.NotNull;

public record CategoryRequestDTO(
        @NotNull String nome,
        String descricao
) {
}
