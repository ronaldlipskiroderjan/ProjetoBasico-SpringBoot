package com.Ronald.Categorizador.service;

import com.Ronald.Categorizador.database.model.EventoEntity;
import com.Ronald.Categorizador.database.repository.EventoRepository;
import com.Ronald.Categorizador.dto.Request.EventoRequestDTO;
import com.Ronald.Categorizador.dto.Response.EventoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventoService {

    private final EventoRepository eventoRepository;

    // GET - Retorna todos os eventos
    public List<EventoResponseDTO> findAll() {
        return eventoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    // GET - Retorna o evento correspondente ao ID
    public EventoResponseDTO findById(Long id) {
        EventoEntity evento = eventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento com " + id + " encontrado"));
        return toDTO(evento);
    }

    // PUT - Realiza a alteração do evento pelo ID
    public EventoResponseDTO update(Long id, EventoRequestDTO dto) {
        EventoEntity evento = eventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento com " + id + " encontrado"));
        evento.setNome(dto.nome());
        evento.setDescricao(dto.descricao());
        evento.setDataEvento(dto.dataEvento());

        eventoRepository.save(evento);
        return toDTO(evento);
    }

    // DELETE - Deleta o evento pelo ID
    public void delete(Long id) {
        if (!(eventoRepository.existsById(id))) {
           throw new RuntimeException("Evento com " + id + "não encontrado");
        }
        eventoRepository.deleteById(id);
    }

    // Método para evitar repetição de código
    private EventoResponseDTO toDTO(EventoEntity eventoEntity) {
        return new EventoResponseDTO(
                eventoEntity.getId(),
                eventoEntity.getNome(),
                eventoEntity.getDescricao(),
                eventoEntity.getDataEvento(),
                eventoEntity.getCreatedAt()
        );
    }
}
