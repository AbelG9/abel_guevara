package com.codigo.abel_guevara.service.impl;

import com.codigo.abel_guevara.dao.AutorDAO;
import com.codigo.abel_guevara.entity.AutorEntity;
import com.codigo.abel_guevara.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutorServiceImpl implements AutorService {
    @Autowired
    private AutorDAO autorDAO;
    @Override
    public AutorEntity crearAutor(AutorEntity autorEntity) {
        autorEntity.setEstado(1);
        return autorDAO.save(autorEntity);
    }

    @Override
    public AutorEntity leerAutorPorId(Long id) throws Exception {
        Optional<AutorEntity> autor = autorDAO.findById(id);
        if (autor.isPresent() && autor.get().getId() == 1) {
            return autor.get();
        } else {
            throw new Exception("Error, el autor solicitado no existe");
        }
    }

    @Override
    public AutorEntity actualizarAutor(Long id, AutorEntity autorEntity) throws Exception {
        Optional<AutorEntity> autor = autorDAO.findById(id);
        if (autor.isPresent() && autor.get().getId() == 1) {
            AutorEntity autorEdit = autor.get();
            autorEdit.setNombre(autorEntity.getNombre());
            return autorDAO.save(autorEdit);
        } else {
            throw new Exception("Error, el autor solicitado no existe");
        }
    }

    @Override
    public AutorEntity eliminarAutor(Long id) throws Exception {
        Optional<AutorEntity> autor = autorDAO.findById(id);
        if (autor.isPresent() && autor.get().getId() == 1) {
            AutorEntity autorEdit = autor.get();
            autorEdit.setEstado(0);
            return autorDAO.save(autorEdit);
        } else {
            throw new Exception("Error, el autor solicitado no existe");
        }
    }

    @Override
    public List<AutorEntity> listarAutores() {
        List<AutorEntity> todoAutores = autorDAO.findAll();
        List<AutorEntity> autores = new ArrayList<>();
        todoAutores.forEach(autor -> {
            if (autor.getEstado() == 1) autores.add(autor);
        });
        return autores;
    }
}
