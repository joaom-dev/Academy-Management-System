package com.juao.sistema_academia_spring.database.repository;

import com.juao.sistema_academia_spring.database.entity.TreinosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITreinosRepository extends JpaRepository<TreinosEntity, Integer> {
}
