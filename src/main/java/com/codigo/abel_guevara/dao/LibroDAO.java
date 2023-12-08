package com.codigo.abel_guevara.dao;

import com.codigo.abel_guevara.entity.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroDAO extends JpaRepository<LibroEntity, Long> {
}

