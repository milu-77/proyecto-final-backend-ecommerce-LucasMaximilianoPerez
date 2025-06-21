package com.techlab.ecommerce.controller;

import com.techlab.ecommerce.model.*;
import com.techlab.ecommerce.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@CrossOrigin(origins = "http://localhost:3000")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @GetMapping
    public List<Item> listar() {
        return itemService.listarTodos();
    }
    @GetMapping("/{id}")
    public ItemCarrito getUserID(int id) {
        return itemService.getByID(id);
    }
    @PostMapping
    public ItemCarrito crear(@RequestBody Usuario producto) {
        return itemService.guardar(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemCarrito> actualizar(@PathVariable Long id, @RequestBody Producto datos) {
        ItemCarrito actualizado = itemService.actualizar(id, datos);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /productos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = itemService.eliminar(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
