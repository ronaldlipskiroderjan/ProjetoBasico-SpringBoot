package com.Ronald.Categorizador.dto.Response;

import java.time.LocalDateTime;

public record EventoResponseDTO(
    Long id,
    String nome,
    String descricao,
    String dataEvento,
    LocalDateTime createdAt
) {
}

