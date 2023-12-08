package com.codigo.abel_guevara.dao;

import com.codigo.abel_guevara.entity.EditorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorDAO extends JpaRepository<EditorEntity, Long> {
}
