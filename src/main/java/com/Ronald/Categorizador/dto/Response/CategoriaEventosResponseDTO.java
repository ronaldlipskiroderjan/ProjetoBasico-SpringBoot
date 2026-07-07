package com.Ronald.Categorizador.dto.Response;

import java.time.LocalDateTime;
import java.util.List;

public record CategoriaEventosResponseDTO(
        Long id,
        String nome,
        String descricao,
        LocalDateTime createdAt,
        List<EventoResponseDTO> eventos
) {
}
