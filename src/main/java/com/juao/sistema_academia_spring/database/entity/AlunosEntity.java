package com.juao.sistema_academia_spring.database.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "alunos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class AlunosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String genero;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_avaliacao")
    private AvaliacaoFisicaEntity avaliacaoFisicaEntity;

    @OneToMany(mappedBy = "alunos")
    private Set<TreinosEntity> treinos = new HashSet<>();

    public void setNm(@NotNull String name) {
    }
}
