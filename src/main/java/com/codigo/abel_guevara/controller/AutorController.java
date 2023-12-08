package com.codigo.abel_guevara.controller;

import com.codigo.abel_guevara.entity.AutorEntity;
import com.codigo.abel_guevara.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @PostMapping("/autor")
    public ResponseEntity<AutorEntity> crearAutor(@RequestBody AutorEntity autorEntity) {
        AutorEntity autor = autorService.crearAutor(autorEntity);
        return new ResponseEntity<>(autor, HttpStatus.CREATED);
    }

    @GetMapping("/autor/{id}")
    public ResponseEntity<AutorEntity> leerAutorPorId(@PathVariable Long id) throws Exception {
        AutorEntity autor = autorService.leerAutorPorId(id);
        return ResponseEntity.ok(autor);
    }

    @PutMapping("/autor/{id}")
    public ResponseEntity<AutorEntity> actualizarAutor(@PathVariable Long id, @RequestBody AutorEntity autorEntity) throws Exception {
        AutorEntity autor = autorService.actualizarAutor(id, autorEntity);
        return ResponseEntity.ok(autor);
    }

    @DeleteMapping("/autor/{id}")
    public ResponseEntity<AutorEntity> eliminarAutor(@PathVariable Long id) throws Exception {
        autorService.eliminarAutor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/autores")
    public List<AutorEntity> listarAutores() {
        List<AutorEntity> autores = autorService.listarAutores();
        return autores;
    }
}
