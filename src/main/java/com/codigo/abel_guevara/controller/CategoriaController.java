package com.codigo.abel_guevara.controller;

import com.codigo.abel_guevara.entity.CategoriaEntity;
import com.codigo.abel_guevara.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/categoria")
    public ResponseEntity<CategoriaEntity> crearCategoria(@RequestBody CategoriaEntity categoriaEntity) {
        CategoriaEntity categoria = categoriaService.crearCategoria(categoriaEntity);
        return new ResponseEntity<>(categoria, HttpStatus.CREATED);
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<CategoriaEntity> leerCategoriaPorId(@PathVariable Long id) throws Exception {
        CategoriaEntity categoria = categoriaService.leerCategoriaPorId(id);
        return ResponseEntity.ok(categoria);
    }

    @PutMapping("/categoria/{id}")
    public ResponseEntity<CategoriaEntity> actualizarCategoria(@PathVariable Long id, @RequestBody CategoriaEntity categoriaEntity) throws Exception {
        CategoriaEntity categoria = categoriaService.actualizarCategoria(id, categoriaEntity);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/categoria/{id}")
    public ResponseEntity<CategoriaEntity> eliminarCategoria(@PathVariable Long id) throws Exception {
        categoriaService.eliminarCategoria(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/categorias")
    public List<CategoriaEntity> listarCategorias() {
        List<CategoriaEntity> categorias = categoriaService.listarCategorias();
        return categorias;
    }
}
