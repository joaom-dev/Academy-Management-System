package com.juao.sistema_academia_spring.service;

import com.juao.sistema_academia_spring.database.entity.AlunosEntity;
import com.juao.sistema_academia_spring.database.entity.ExercicioEntity;
import com.juao.sistema_academia_spring.database.repository.IExercicioRepository;
import com.juao.sistema_academia_spring.dto.AlunoDto;
import com.juao.sistema_academia_spring.dto.ExercicioDto;
//import com.juao.sistema_academia_spring.exception.NotFoundException;
import com.juao.sistema_academia_spring.exception.NotFoundException;
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

    public void postExercicio(ExercicioDto ExercicioDto) {
        ExercicioEntity postExercicio = ExercicioEntity.builder()
                        .nome(ExercicioDto.getNome())
                        .grupoMuscular(ExercicioDto.getGrupoMuscular())
                .build();

        exercicioRepository.save(postExercicio);
    }

    public void deleteExercicio(Integer id) {
        if (!exercicioRepository.existsById(id)) {
            throw new RuntimeException("Exercicio com o id " + id + " nao encontrado no banco de dados");
        }
        exercicioRepository.deleteById(id);
    }

    public ExercicioEntity putExercicio(ExercicioDto exercicioDto, Integer id) throws NotFoundException {
        ExercicioEntity putExercicio = exercicioRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Exercicio nao econtrado pelo id: "+id));
        putExercicio.setNome(exercicioDto.getNome());
        putExercicio.setGrupoMuscular(exercicioDto.getGrupoMuscular());

        return exercicioRepository.save(putExercicio);
    }

    public ExercicioEntity patchExercicio(ExercicioDto exercicioDto, Integer id) throws NotFoundException {
        ExercicioEntity patchExercicio = exercicioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Exercicio nao encontrado pelo id: " + id));

        if (exercicioDto.getNome() != null) {
            patchExercicio.setNome(exercicioDto.getNome());
        }
        if (exercicioDto.getGrupoMuscular() != null) {
            patchExercicio.setGrupoMuscular(exercicioDto.getGrupoMuscular());
        }

        return exercicioRepository.save(patchExercicio);
    }
}
