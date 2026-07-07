package com.Ronald.Categorizador.database.repository;

import com.Ronald.Categorizador.database.model.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
}
