package com.codigo.abel_guevara.service;

import com.codigo.abel_guevara.entity.EditorEntity;

import java.util.List;

public interface EditorService {
    EditorEntity crearEditor(EditorEntity editorEntity);
    EditorEntity leerEditorPorId(Long id) throws Exception;
    EditorEntity actualizarEditor(Long id, EditorEntity editorEntity) throws  Exception;
    EditorEntity eliminarEditor(Long id) throws Exception;
    List<EditorEntity> listarEditores();
}
