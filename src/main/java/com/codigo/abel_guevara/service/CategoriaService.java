package com.codigo.abel_guevara.service;

import com.codigo.abel_guevara.entity.CategoriaEntity;

import java.util.List;

public interface CategoriaService {
    CategoriaEntity crearCategoria(CategoriaEntity categoriaEntity);
    CategoriaEntity leerCategoriaPorId(Long id) throws Exception;
    CategoriaEntity actualizarCategoria(Long id, CategoriaEntity categoriaEntity) throws Exception;
    CategoriaEntity eliminarCategoria(Long id) throws Exception;
    List<CategoriaEntity> listarCategorias();
}
