package com.juao.sistema_academia_spring.database.repository;

import com.juao.sistema_academia_spring.database.entity.AlunosEntity;
import com.juao.sistema_academia_spring.database.entity.TreinosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITreinosRepository extends JpaRepository<TreinosEntity, Integer> {
    Optional<TreinosEntity> findByNomeAndAlunoId(String nome, Integer id);
}
