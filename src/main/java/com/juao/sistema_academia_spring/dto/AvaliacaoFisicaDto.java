package com.juao.sistema_academia_spring.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AvaliacaoFisicaDto {

    @Column(name = "id_alunos")
    @NotNull
    private Integer idAlunos;
    @NotNull
    private BigDecimal peso;
    @NotNull
    private BigDecimal altura;
    @NotNull
    private BigDecimal porcentagemGordura;


}

