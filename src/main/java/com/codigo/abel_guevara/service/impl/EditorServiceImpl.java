package com.codigo.abel_guevara.service.impl;

import com.codigo.abel_guevara.dao.EditorDAO;
import com.codigo.abel_guevara.entity.EditorEntity;
import com.codigo.abel_guevara.service.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EditorServiceImpl implements EditorService {
    @Autowired
    EditorDAO editorDAO;
    @Override
    public EditorEntity crearEditor(EditorEntity editorEntity) {
        editorEntity.setEstado(1);
        return editorDAO.save(editorEntity);
    }

    @Override
    public EditorEntity leerEditorPorId(Long id) throws Exception {
        Optional<EditorEntity> editor = editorDAO.findById(id);
        if (editor.isPresent() && editor.get().getEstado() == 1) {
            return editor.get();
        } else {
            throw new Exception("Error, el editor solicitado no existe");
        }
    }

    @Override
    public EditorEntity actualizarEditor(Long id, EditorEntity editorEntity) throws Exception {
        Optional<EditorEntity> editor = editorDAO.findById(id);
        if (editor.isPresent() && editor.get().getEstado() == 1) {
            EditorEntity editorEdit  = editor.get();
            editorEdit.setNombre(editorEntity.getNombre());
            return editorDAO.save(editorEdit);
        } else {
            throw new Exception("Error, el editor solicitado no existe");
        }
    }

    @Override
    public EditorEntity eliminarEditor(Long id) throws Exception {
        Optional<EditorEntity> editor = editorDAO.findById(id);
        if (editor.isPresent() && editor.get().getEstado() == 1) {
            EditorEntity editorEdit  = editor.get();
            editorEdit.setEstado(0);
            return editorDAO.save(editorEdit);
        } else {
            throw new Exception("Error, el editor solicitado no existe");
        }
    }

    @Override
    public List<EditorEntity> listarEditores() {
        List<EditorEntity> todoEditores = editorDAO.findAll();
        List<EditorEntity> editores = new ArrayList<>();
        todoEditores.forEach(editor -> {
            if (editor.getEstado() == 1) editores.add(editor);
        });
        return editores;
    }
}
