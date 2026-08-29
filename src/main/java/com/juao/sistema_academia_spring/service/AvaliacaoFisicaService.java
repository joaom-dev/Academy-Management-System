package com.juao.sistema_academia_spring.service;

import com.juao.sistema_academia_spring.database.entity.AlunosEntity;
import com.juao.sistema_academia_spring.database.entity.AvaliacaoFisicaEntity;
import com.juao.sistema_academia_spring.database.repository.IAlunosRepository;
import com.juao.sistema_academia_spring.database.repository.IAvaliacaoFisicaRepository;
import com.juao.sistema_academia_spring.dto.AvaliacaoFisicaDto;
import com.juao.sistema_academia_spring.exception.BadRequestException;
import com.juao.sistema_academia_spring.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliacaoFisicaService {

    private final IAlunosRepository alunosRepository;
    private final IAvaliacaoFisicaRepository avaliacaoFisicaRepository;

    public List<AvaliacaoFisicaEntity> findAll() {
        return avaliacaoFisicaRepository.findAll();
    }

    public void postAvaliacaoFisica(AvaliacaoFisicaDto avaliacaoFisicaDto) throws NotFoundException, BadRequestException {
        AlunosEntity aluno = alunosRepository.findById(avaliacaoFisicaDto.getIdAlunos())
                .orElseThrow(() -> new NotFoundException("Aluno não econtrado"));
        AvaliacaoFisicaEntity avaliacaoFisica = aluno.getAvaliacaoFisicaEntity();

        if (avaliacaoFisica != null) {
            throw new BadRequestException("Aluno já possui avaliacao fisica cadastrada");
        }

        avaliacaoFisica = AvaliacaoFisicaEntity.builder()
                    .peso(avaliacaoFisicaDto.getPeso())
                    .altura(avaliacaoFisicaDto.getAltura())
                    .gordura(avaliacaoFisicaDto.getPorcentagemGordura())
                .build();

        aluno.setAvaliacaoFisicaEntity(avaliacaoFisica);
        alunosRepository.save(aluno);
    }
}
