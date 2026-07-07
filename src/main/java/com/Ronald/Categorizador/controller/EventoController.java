package com.Ronald.Categorizador.controller;

import com.Ronald.Categorizador.dto.Request.EventoRequestDTO;
import com.Ronald.Categorizador.dto.Response.EventoResponseDTO;
import com.Ronald.Categorizador.service.EventoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
@RequiredArgsConstructor
public class EventoController {

    private final EventoService service;

    @GetMapping
    public ResponseEntity<List<EventoResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> update(@PathVariable Long id, @RequestBody EventoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto));
    }
}
