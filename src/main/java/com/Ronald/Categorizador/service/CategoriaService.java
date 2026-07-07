package com.Ronald.Categorizador.service;

import com.Ronald.Categorizador.database.model.CategoriaEntity;
import com.Ronald.Categorizador.database.model.EventoEntity;
import com.Ronald.Categorizador.database.repository.CategoriaRepository;
import com.Ronald.Categorizador.database.repository.EventoRepository;
import com.Ronald.Categorizador.dto.Request.CategoryRequestDTO;
import com.Ronald.Categorizador.dto.Request.EventoRequestDTO;
import com.Ronald.Categorizador.dto.Response.CategoriaEventosResponseDTO;
import com.Ronald.Categorizador.dto.Response.CategoriaResponseDTO;
import com.Ronald.Categorizador.dto.Response.EventoCategoriaResponseDTO;
import com.Ronald.Categorizador.dto.Response.EventoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final EventoRepository eventoRepository;

    // POST - Cria um evento vinculado ao ID da uma categoria existente
    public EventoCategoriaResponseDTO createEvento(Long Id, EventoRequestDTO dto) {
        CategoriaEntity categoria = categoriaRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Categoria não existente!!"));

        EventoEntity evento = new EventoEntity();
        evento.setNome(dto.nome());
        evento.setDescricao(dto.descricao());
        evento.setDataEvento(dto.dataEvento());
        evento.setCreatedAt(LocalDateTime.now());
        evento.setCategoriaId(categoria);

        eventoRepository.save(evento);
        return new EventoCategoriaResponseDTO(
                evento.getId(),
                evento.getNome(),
                evento.getDescricao(),
                evento.getDataEvento(),
                evento.getCreatedAt(),
                toDTO(categoria)
        );
    }

    // POST - Cria uma categoria e a retorna
    public CategoriaResponseDTO createCategory(CategoryRequestDTO dto) {
        CategoriaEntity category = new CategoriaEntity();
        category.setNome(dto.nome());
        category.setDescricao(dto.descricao());
        category.setCreatedAt(LocalDateTime.now());

        categoriaRepository.save(category);
        return toDTO(category);
    }

    // GET - Retorna todas as categorias
    public List<CategoriaResponseDTO> findAllCategory() {
        return categoriaRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    // GET - Retorna a categoria pelo ID
    public CategoriaEventosResponseDTO findCategoryById(Long id) {
        CategoriaEntity category = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada!"));

        List<EventoResponseDTO> eventos = category.getEventos()
                .stream()
                .map(evento -> new EventoResponseDTO(
                        evento.getId(),
                        evento.getNome(),
                        evento.getDescricao(),
                        evento.getDataEvento(),
                        evento.getCreatedAt()
                ))
                .toList();

        return new CategoriaEventosResponseDTO(
                category.getId(),
                category.getNome(),
                category.getDescricao(),
                category.getCreatedAt(),
                eventos
        );
    }

    // PUT - Altera pelo ID
    public CategoriaResponseDTO alterCategory(Long id, CategoryRequestDTO dto) {
        CategoriaEntity category = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada!"));
        category.setNome(dto.nome());
        category.setDescricao(dto.descricao());

        categoriaRepository.save(category);
        return toDTO(category);
    }

    // DELETE - Deleta pelo ID
    public void deleteCategory(Long id) {
        if (!(categoriaRepository.existsById(id))) {
            throw new RuntimeException("Categoria não encontrada!!");
        };
        categoriaRepository.deleteById(id);
    }

    // Método para evitar repetição de código
    private CategoriaResponseDTO toDTO(CategoriaEntity category) {
        return new CategoriaResponseDTO(
                category.getId(),
                category.getNome(),
                category.getDescricao(),
                category.getCreatedAt()
        );
    }
}
