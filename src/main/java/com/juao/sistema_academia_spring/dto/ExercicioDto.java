package com.juao.sistema_academia_spring.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class ExercicioDto {

    @NotBlank(message = "nome nao pode ser vazio")
    private String nome;
    @NotBlank(message = "grupo muscular nao pode ser vazio")
    private String grupoMuscular;


}