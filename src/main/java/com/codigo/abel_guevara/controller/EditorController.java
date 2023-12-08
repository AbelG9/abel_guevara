package com.codigo.abel_guevara.controller;

import com.codigo.abel_guevara.entity.EditorEntity;
import com.codigo.abel_guevara.service.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EditorController {
    @Autowired
    private EditorService editorService;

    @PostMapping("/editor")
    public ResponseEntity<EditorEntity> crearEditor(@RequestBody EditorEntity editorEntity) {
        EditorEntity editor = editorService.crearEditor(editorEntity);
        return new ResponseEntity<>(editor, HttpStatus.CREATED);
    }

    @GetMapping("/editor/{id}")
    public ResponseEntity<EditorEntity> leerEditorPorId(@PathVariable Long id) throws Exception {
        EditorEntity editor = editorService.leerEditorPorId(id);
        return ResponseEntity.ok(editor);
    }

    @PutMapping("/editor/{id}")
    public ResponseEntity<EditorEntity> actualizarEditor(@PathVariable Long id, @RequestBody EditorEntity editorEntity) throws Exception {
        EditorEntity editor = editorService.actualizarEditor(id, editorEntity);
        return ResponseEntity.ok(editor);
    }

    @DeleteMapping("/editor/{id}")
    public ResponseEntity<EditorEntity> eliminarEditor(@PathVariable Long id) throws Exception {
        editorService.eliminarEditor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/editores")
    public List<EditorEntity> listarEditores() {
        List<EditorEntity> editores = editorService.listarEditores();
        return editores;
    }
}
