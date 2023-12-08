package com.codigo.abel_guevara.service;

import com.codigo.abel_guevara.entity.LibroEntity;

import java.util.List;

public interface LibroService {
    LibroEntity crearLibro(LibroEntity libroEntity);
    LibroEntity leerLibroPorId(Long id) throws Exception;
    LibroEntity actualizarLibro(Long id, LibroEntity libroEntity) throws Exception;
    LibroEntity eliminarLibro(Long id) throws Exception;
    List<LibroEntity> listarLibros();
}
