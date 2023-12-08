package com.codigo.abel_guevara.service;

import com.codigo.abel_guevara.entity.AutorEntity;

import java.util.List;

public interface AutorService {
    AutorEntity crearAutor(AutorEntity autorEntity);
    AutorEntity leerAutorPorId(Long id) throws Exception;
    AutorEntity actualizarAutor(Long id, AutorEntity autorEntity) throws Exception;
    AutorEntity eliminarAutor(Long id) throws Exception;
    List<AutorEntity> listarAutores();
}
