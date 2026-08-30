package com.juao.sistema_academia_spring.controller;

import com.juao.sistema_academia_spring.database.entity.AlunosEntity;
import com.juao.sistema_academia_spring.dto.AlunoDto;
import com.juao.sistema_academia_spring.exception.NotFoundException;
import com.juao.sistema_academia_spring.service.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/juao/alunos")
@RequiredArgsConstructor
@Validated
public class AlunoController {

    private final AlunoService alunosService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AlunosEntity> findAll () {
        return alunosService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postAlunos (@Valid @RequestBody AlunoDto alunoDto) {
        alunosService.postAlunos(alunoDto);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlunos(@PathVariable Integer id) throws NotFoundException {
        alunosService.deleteAluno(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AlunosEntity putAlunos(@PathVariable Integer id, @RequestBody AlunoDto alunoDto) throws NotFoundException {
        return  alunosService.putAluno(alunoDto, id);
    }

    @PatchMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AlunosEntity patchAlunos(@PathVariable Integer id, @RequestBody AlunoDto alunoDto) throws NotFoundException {
        return alunosService.patchAluno(alunoDto, id);
    }
}
