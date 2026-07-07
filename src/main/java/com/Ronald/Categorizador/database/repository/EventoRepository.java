package com.Ronald.Categorizador.database.repository;

import com.Ronald.Categorizador.database.model.EventoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<EventoEntity, Long> {
}
