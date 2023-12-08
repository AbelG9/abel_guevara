package com.codigo.abel_guevara.controller;

import com.codigo.abel_guevara.entity.LibroEntity;
import com.codigo.abel_guevara.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @PostMapping("/libro")
    public ResponseEntity<LibroEntity> crearLibro(@RequestBody LibroEntity libroEntity) {
        LibroEntity libro = libroService.crearLibro(libroEntity);
        return new ResponseEntity<>(libro, HttpStatus.CREATED);
    }

    @GetMapping("/libro/{id}")
    public ResponseEntity<LibroEntity> leerLibroPorId(@PathVariable Long id) throws Exception {
        LibroEntity libro = libroService.leerLibroPorId(id);
        return ResponseEntity.ok(libro);
    }

    @PutMapping("/libro/{id}")
    public ResponseEntity<LibroEntity> actualizarLibro(@PathVariable Long id, @RequestBody LibroEntity libroEntity) throws Exception {
        LibroEntity libro = libroService.actualizarLibro(id, libroEntity);
        return ResponseEntity.ok(libro);
    }

    @DeleteMapping("/libro/{id}")
    public ResponseEntity<LibroEntity> eliminarLibro(@PathVariable Long id) throws Exception {
        libroService.eliminarLibro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/libros")
    public List<LibroEntity> listarLibros() {
        List<LibroEntity> libros = libroService.listarLibros();
        return libros;
    }
}
