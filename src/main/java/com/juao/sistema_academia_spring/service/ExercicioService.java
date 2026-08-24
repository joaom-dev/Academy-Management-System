package com.juao.sistema_academia_spring.service;

import com.juao.sistema_academia_spring.database.entity.ExercicioEntity;
import com.juao.sistema_academia_spring.database.repository.IExercicioRepository;
import com.juao.sistema_academia_spring.dto.ExercicioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExercicioService {

    private final IExercicioRepository exercicioRepository;

    public List<ExercicioEntity> findAll(){
        return exercicioRepository.findAll();
    }

    public void criarExercicio(ExercicioDto ExercicioDto) {
        ExercicioEntity criarExercicio = ExercicioEntity.builder()
                        .nome(ExercicioDto.getNome())
                        .grupoMuscular(ExercicioDto.getGrupoMuscular())
                .build();

        exercicioRepository.save(criarExercicio);
    }

    public void deleteExercicio(Integer id) {
        if (!exercicioRepository.existsById(id)) {
            throw new RuntimeException("Exercicio com o id " + id + " nao encontrado no banco de dados");
        }
        exercicioRepository.deleteById(id);
    }

    public ExercicioEntity putExercicio(ExercicioDto exercicioDto, Integer id) {
        ExercicioEntity putExercicio = exercicioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Exercicio nao econtrado pelo id "+id));
        putExercicio.setNome(exercicioDto.getNome());
        putExercicio.setGrupoMuscular(exercicioDto.getGrupoMuscular());

        return exercicioRepository.save(putExercicio);
    }
}
