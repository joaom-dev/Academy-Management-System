package com.juao.sistema_academia_spring.controller;

import com.juao.sistema_academia_spring.database.entity.ExercicioEntity;
import com.juao.sistema_academia_spring.database.entity.TreinosEntity;
import com.juao.sistema_academia_spring.dto.ExercicioDto;
import com.juao.sistema_academia_spring.dto.TreinosDto;
import com.juao.sistema_academia_spring.exception.NotFoundException;
import com.juao.sistema_academia_spring.service.TreinosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/juao/treinos")
@RequiredArgsConstructor
@Validated
public class TreinosController {

    private final TreinosService treinosService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TreinosEntity> findAll() {
        return treinosService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postTreinos(@Valid @RequestBody TreinosDto treinosDto, Integer id) throws NotFoundException {
        treinosService.postTreinos(treinosDto, id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TreinosEntity putTreinos(@PathVariable Integer id, @RequestBody TreinosDto treinosDto) throws NotFoundException {
        return  treinosService.putTreinos(treinosDto, id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTreinos(@PathVariable Integer id) {
        treinosService.deleteTreinos(id);
    }

    @PatchMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TreinosEntity patchTreinos(@PathVariable Integer id, @RequestBody TreinosDto treinosDto) throws NotFoundException {
        return treinosService.patchTreinos(treinosDto, id);
    }
}
