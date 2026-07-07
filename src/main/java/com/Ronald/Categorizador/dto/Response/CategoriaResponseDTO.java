package com.Ronald.Categorizador.dto.Response;

import java.time.LocalDateTime;
import java.util.UUID;

public record CategoriaResponseDTO(
        Long id,
        String nome,
        String descricao,
        LocalDateTime createdAt
) {
}
