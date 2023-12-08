package com.codigo.abel_guevara.dao;

import com.codigo.abel_guevara.entity.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorDAO extends JpaRepository<AutorEntity, Long> {
}
