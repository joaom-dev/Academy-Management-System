package com.juao.sistema_academia_spring.controller;

import com.juao.sistema_academia_spring.database.entity.AvaliacaoFisicaEntity;
import com.juao.sistema_academia_spring.database.entity.ExercicioEntity;
import com.juao.sistema_academia_spring.dto.AvaliacaoFisicaDto;
import com.juao.sistema_academia_spring.exception.BadRequestException;
import com.juao.sistema_academia_spring.exception.NotFoundException;
import com.juao.sistema_academia_spring.service.AvaliacaoFisicaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/juao/avaliacoes")
@RequiredArgsConstructor
@Validated
public class AvaliacaoFisicaController {

    private final AvaliacaoFisicaService avaliacaoFisicaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AvaliacaoFisicaEntity> findAll(){
        return avaliacaoFisicaService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postAvaliacaoFisica(@Valid @RequestBody AvaliacaoFisicaDto avaliacaoFisicaDto) throws NotFoundException, BadRequestException {
        avaliacaoFisicaService.postAvaliacaoFisica(avaliacaoFisicaDto);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAvaliacaoFisica(@PathVariable Integer id) {
        avaliacaoFisicaService.deleteAvaliacaoFisica(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AvaliacaoFisicaEntity putAvaliacaoFisica(@PathVariable Integer id, @RequestBody AvaliacaoFisicaDto avaliacaoFisicaDto) throws NotFoundException {
        return  avaliacaoFisicaService.putAvaliacaoFisica(avaliacaoFisicaDto, id);
    }
}
