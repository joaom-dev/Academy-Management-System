package com.juao.sistema_academia_spring.service;

import com.juao.sistema_academia_spring.database.entity.AlunosEntity;
import com.juao.sistema_academia_spring.database.entity.AvaliacaoFisicaEntity;
import com.juao.sistema_academia_spring.database.entity.ExercicioEntity;
import com.juao.sistema_academia_spring.database.repository.IAlunosRepository;
import com.juao.sistema_academia_spring.dto.AlunoDto;
import com.juao.sistema_academia_spring.dto.ExercicioDto;
import com.juao.sistema_academia_spring.exception.BadRequestException;
import com.juao.sistema_academia_spring.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final IAlunosRepository alunosRepository;

    public List<AlunosEntity> findAll() {
        return alunosRepository.findAll();
    }
    public void postAlunos(AlunoDto alunoDto) {
        AlunosEntity alunos = alunosRepository.findByEmail(alunoDto.getEmail())
                .orElse(null);

        if (alunos != null) {
            throw new BadRequestException("Aluno já cadastrado com este email");
        }

        alunosRepository.save(AlunosEntity.builder()
                        .name(alunoDto.getName())
                        .email(alunoDto.getEmail())
                .build());
    }

    public void deleteAluno(Integer id) {
        if (!alunosRepository.existsById(id)) {
            throw new RuntimeException("Aluno com o id " + id + " nao encontrado no banco de dados");
        }
        alunosRepository.deleteById(id);
    }

    public AlunosEntity putAluno(AlunoDto alunoDto, Integer id) throws NotFoundException {
        AlunosEntity putAluno = alunosRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Exercicio nao econtrado pelo id: "+id));
        putAluno.setName(alunoDto.getName());
        putAluno.setEmail(alunoDto.getEmail());

        return alunosRepository.save(putAluno);
    }
}
