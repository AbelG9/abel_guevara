package com.codigo.abel_guevara.service.impl;

import com.codigo.abel_guevara.dao.LibroDAO;
import com.codigo.abel_guevara.entity.AutorEntity;
import com.codigo.abel_guevara.entity.LibroEntity;
import com.codigo.abel_guevara.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {
    @Autowired
    private LibroDAO libroDAO;
    @Override
    public LibroEntity crearLibro(LibroEntity libroEntity) {
        libroEntity.setEstado(1);
        return libroDAO.save(libroEntity);
    }

    @Override
    public LibroEntity leerLibroPorId(Long id) throws Exception {
        Optional<LibroEntity> libro = libroDAO.findById(id);
        if (libro.isPresent() && libro.get().getEstado() == 1) {
            return libro.get();
        } else {
            throw new Exception("Error, el libro solicitado no existe");
        }
    }

    @Override
    public LibroEntity actualizarLibro(Long id, LibroEntity libroEntity) throws Exception {
        Optional<LibroEntity> libro = libroDAO.findById(id);
        if (libro.isPresent() && libro.get().getEstado() == 1) {
            LibroEntity libroEdit = libro.get();
            libroEdit.setTitulo(libroEntity.getTitulo());
            libroEdit.setEditor(libroEntity.getEditor());
            libroEdit.setAutores(libroEntity.getAutores());
            libroEdit.setCategorias(libroEntity.getCategorias());
            return libroDAO.save(libroEdit);
        } else {
            throw new Exception("Error, el libro solicitado no existe");
        }
    }

    @Override
    public LibroEntity eliminarLibro(Long id) throws Exception {
        Optional<LibroEntity> libro = libroDAO.findById(id);
        if (libro.isPresent() && libro.get().getEstado() == 1) {
            LibroEntity libroEdit = libro.get();
            libroEdit.setEstado(0);
            return libroDAO.save(libroEdit);
        } else {
            throw new Exception("Error, el libro solicitado no existe");
        }
    }

    @Override
    public List<LibroEntity> listarLibros() {
        List<LibroEntity> todoLibros = libroDAO.findAll();
        List<LibroEntity> libros = new ArrayList<>();
        todoLibros.forEach(libro -> {
            if (libro.getEstado() == 1) libros.add(libro);
        });
        return libros;
    }
}
