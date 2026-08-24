package com.juao.sistema_academia_spring.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "exercicios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class ExercicioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "grupo_muscular", nullable = false)
    private String grupoMuscular;


}
