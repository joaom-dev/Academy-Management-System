package com.juao.sistema_academia_spring.service;


import com.juao.sistema_academia_spring.database.entity.AlunosEntity;
import com.juao.sistema_academia_spring.database.entity.ExercicioEntity;
import com.juao.sistema_academia_spring.database.entity.TreinosEntity;
import com.juao.sistema_academia_spring.database.repository.IAlunosRepository;
import com.juao.sistema_academia_spring.database.repository.IExercicioRepository;
import com.juao.sistema_academia_spring.database.repository.ITreinosRepository;
import com.juao.sistema_academia_spring.dto.ExercicioDto;
import com.juao.sistema_academia_spring.dto.TreinosDto;
import com.juao.sistema_academia_spring.exception.BadRequestException;
import com.juao.sistema_academia_spring.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TreinosService {

    private final ITreinosRepository treinosRepository;
    private final IAlunosRepository alunosRepository;
    private final IExercicioRepository exercicioRepository;

    public List<TreinosEntity> findAll(){
        return treinosRepository.findAll();
    }

    public void postTreinos (TreinosDto treinosDto, Integer id) throws NotFoundException {
        Set<ExercicioEntity> exercicioEntitySet = new HashSet<>();

        AlunosEntity alunos = alunosRepository.findById(treinosDto.getAluno())
                .orElseThrow(() -> new NotFoundException("Aluno não econtrado"));

        TreinosEntity treinos = treinosRepository.findByNomeAndAlunoId(treinosDto.getNome(), treinosDto.getAluno())
                .orElse(null);

        if (treinos != null) {
            throw new BadRequestException("Já possui treinos com esse nome para este aluno");
        }

        for (Integer exercicioId : treinosDto.getExercicios()) {
            ExercicioEntity exercicio = exercicioRepository.findById(exercicioId)
                    .orElseThrow(() -> new NotFoundException("Exercicio não econtrado"));

            exercicioEntitySet.add(exercicio);
        }

        treinos = TreinosEntity.builder()
                .nome(treinosDto.getNome())
                .alunos(alunos)
                .exercicios(exercicioEntitySet)
                .build();
        treinosRepository.save(treinos);
    }

    public void deleteTreinos(Integer id) {
        if (!treinosRepository.existsById(id)) {
            throw new RuntimeException("Treino com o id " + id + " nao encontrado no banco de dados");
        }
        treinosRepository.deleteById(id);
    }

    public TreinosEntity putTreinos(TreinosDto treinosDto, Integer id) throws NotFoundException {
        TreinosEntity putTreinos = treinosRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Treino nao encontrado pelo id: " + id));
        putTreinos.setNome(treinosDto.getNome());

        AlunosEntity aluno = alunosRepository.findById(treinosDto.getAluno())
                .orElseThrow(() -> new NotFoundException("Aluno nao encontrado pelo id: " + treinosDto.getAluno()));
        putTreinos.setAlunos(aluno);

        Set<ExercicioEntity> exercicios = exercicioRepository.findAllById(treinosDto.getExercicios())
                .stream()
                .collect(Collectors.toSet());
        putTreinos.setExercicios(exercicios);

        return treinosRepository.save(putTreinos);
    }

    public TreinosEntity patchTreinos(TreinosDto treinosDto, Integer id) throws NotFoundException {
        TreinosEntity patchTreinos = treinosRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Treino nao encontrado pelo id: " + id));

        if (treinosDto.getNome() != null) {
            patchTreinos.setNome(treinosDto.getNome());
        }
        if (treinosDto.getAluno() != null) {
            AlunosEntity aluno = alunosRepository.findById(treinosDto.getAluno())
                    .orElseThrow(() -> new NotFoundException("Aluno nao encontrado pelo id: " + treinosDto.getAluno()));
            patchTreinos.setAlunos(aluno);
        }

        if (treinosDto.getExercicios() != null) {
            Set<ExercicioEntity> exercicios = exercicioRepository.findAllById(treinosDto.getExercicios())
                    .stream()
                    .collect(Collectors.toSet());
            patchTreinos.setExercicios(exercicios);
        }

        return treinosRepository.save(patchTreinos);
    }
}
