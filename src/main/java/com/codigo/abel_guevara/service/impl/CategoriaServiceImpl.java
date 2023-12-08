package com.codigo.abel_guevara.service.impl;

import com.codigo.abel_guevara.dao.CategoriaDAO;
import com.codigo.abel_guevara.entity.CategoriaEntity;
import com.codigo.abel_guevara.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    CategoriaDAO categoriaDAO;
    @Override
    public CategoriaEntity crearCategoria(CategoriaEntity categoriaEntity) {
        categoriaEntity.setEstado(1);
        return categoriaDAO.save(categoriaEntity);
    }

    @Override
    public CategoriaEntity leerCategoriaPorId(Long id) throws Exception {
        Optional<CategoriaEntity> categoria = categoriaDAO.findById(id);
        if (categoria.isPresent() && categoria.get().getEstado() == 1) {
            return categoria.get();
        } else {
            throw new Exception("Error, la categoria solicitada no existe");
        }
    }

    @Override
    public CategoriaEntity actualizarCategoria(Long id, CategoriaEntity categoriaEntity) throws Exception {
        Optional<CategoriaEntity> categoria = categoriaDAO.findById(id);
        if (categoria.isPresent() && categoria.get().getEstado() == 1) {
            CategoriaEntity categoriaEdit = categoria.get();
            categoriaEdit.setNombre(categoriaEntity.getNombre());
            return categoriaDAO.save(categoriaEdit);
        } else {
            throw new Exception("Error, la categoria solicitada no existe");
        }
    }

    @Override
    public CategoriaEntity eliminarCategoria(Long id) throws Exception {
        Optional<CategoriaEntity> categoria = categoriaDAO.findById(id);
        if (categoria.isPresent() && categoria.get().getEstado() == 1) {
            CategoriaEntity categoriaEdit = categoria.get();
            categoriaEdit.setEstado(0);
            return categoriaDAO.save(categoriaEdit);
        } else {
            throw new Exception("Error, la categoria solicitada no existe");
        }
    }

    @Override
    public List<CategoriaEntity> listarCategorias() {
        List<CategoriaEntity> todoCategorias = categoriaDAO.findAll();
        List<CategoriaEntity> categorias = new ArrayList<>();
        todoCategorias.forEach(categoria -> {
            if (categoria.getEstado() == 1) categorias.add(categoria);
        });
        return categorias;
    }
}
