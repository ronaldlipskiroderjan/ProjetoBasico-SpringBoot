package com.Ronald.Categorizador.controller;

import com.Ronald.Categorizador.dto.Request.CategoryRequestDTO;
import com.Ronald.Categorizador.dto.Request.EventoRequestDTO;
import com.Ronald.Categorizador.dto.Response.CategoriaEventosResponseDTO;
import com.Ronald.Categorizador.dto.Response.CategoriaResponseDTO;
import com.Ronald.Categorizador.dto.Response.EventoCategoriaResponseDTO;
import com.Ronald.Categorizador.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoriaService service;

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> createNewCategory(@RequestBody CategoryRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createCategory(dto));
    }

    @PostMapping("/{Id}/eventos")
    public ResponseEntity<EventoCategoriaResponseDTO> createNewEvento(@PathVariable Long Id, @RequestBody EventoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createEvento(Id, dto));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> findAllCategory() {
        return ResponseEntity.ok(service.findAllCategory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaEventosResponseDTO> findCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findCategoryById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> alterCatgory (@PathVariable Long id, @RequestBody CategoryRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.alterCategory(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory (@PathVariable Long id) {
        service.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
