package com.juao.sistema_academia_spring.database.repository;

import com.juao.sistema_academia_spring.database.entity.AvaliacaoFisicaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisicaEntity, Integer> {
}
