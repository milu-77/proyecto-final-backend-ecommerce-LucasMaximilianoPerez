package com.techlab.ecommerce.controller;

import com.techlab.ecommerce.model.*;
import com.techlab.ecommerce.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;
    @GetMapping
    public List<Categoria> listar() {
        return categoriaService.listarTodos();
    }
    @GetMapping("/{id}")
    public  Categoria  getUserID(@PathVariable Long id) {

        return  categoriaService.getByID(id) ;
    }
    @PostMapping
    public Categoria crear(@RequestBody Usuario producto) {
        return categoriaService.guardar(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizar(@PathVariable Long id, @RequestBody Producto datos) {
        Categoria actualizado = categoriaService.actualizar(id, datos);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /productos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = categoriaService.eliminar(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
