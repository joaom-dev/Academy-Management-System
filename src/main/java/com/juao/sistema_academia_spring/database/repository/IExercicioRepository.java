package com.juao.sistema_academia_spring.database.repository;

import com.juao.sistema_academia_spring.database.entity.ExercicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExercicioRepository extends JpaRepository<ExercicioEntity, Integer> {

}
