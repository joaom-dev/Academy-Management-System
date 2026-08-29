package com.juao.sistema_academia_spring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class TreinosDto {

    @NotNull
    private Integer aluno;
    @NotBlank
    private String nome;
    @NotEmpty
    private List<Integer> exercicios;

}