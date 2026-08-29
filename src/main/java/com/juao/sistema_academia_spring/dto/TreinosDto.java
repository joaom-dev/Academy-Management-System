package com.juao.sistema_academia_spring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class TreinosDto {

    @NotBlank
    private Integer aluno;
    @NotBlank
    private String nome;
    @NotEmpty
    private List<Integer> exercicios;

}