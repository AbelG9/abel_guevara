package com.codigo.abel_guevara.dao;

import com.codigo.abel_guevara.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaDAO extends JpaRepository<CategoriaEntity, Long> {
}
