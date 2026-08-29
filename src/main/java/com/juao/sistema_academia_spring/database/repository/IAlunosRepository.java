package com.juao.sistema_academia_spring.database.repository;

import com.juao.sistema_academia_spring.database.entity.AlunosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAlunosRepository extends JpaRepository<AlunosEntity,Integer>  {
    Optional<AlunosEntity> findByEmail(String email);
}
