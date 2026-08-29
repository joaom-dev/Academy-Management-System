package com.juao.sistema_academia_spring.controller;

import com.juao.sistema_academia_spring.database.entity.AlunosEntity;
import com.juao.sistema_academia_spring.database.entity.ExercicioEntity;
import com.juao.sistema_academia_spring.dto.AlunoDto;
import com.juao.sistema_academia_spring.dto.ExercicioDto;
import com.juao.sistema_academia_spring.exception.NotFoundException;

import com.juao.sistema_academia_spring.service.ExercicioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/juao/exercicios")
@RequiredArgsConstructor
@Validated
public class ExercicioController {

    private final ExercicioService exercicioService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ExercicioEntity> findAll(){
        return exercicioService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postExercicio(@Valid @RequestBody ExercicioDto ExercicioDto) {
        exercicioService.postExercicio(ExercicioDto);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExercicio(@PathVariable Integer id) {
        exercicioService.deleteExercicio(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ExercicioEntity putExercicio(@PathVariable Integer id, @RequestBody ExercicioDto exercicioDto) throws NotFoundException {
        return  exercicioService.putExercicio(exercicioDto, id);
    }

    @PatchMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ExercicioEntity patchExercicio(@PathVariable Integer id, @RequestBody ExercicioDto exercicioDto) throws NotFoundException {
        return exercicioService.patchExercicio(exercicioDto, id);
    }
}
