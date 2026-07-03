package com.Ronald.Categorizador.database.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "eventos")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EventoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Column(name = "data_evento")
    private String dataEvento;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
