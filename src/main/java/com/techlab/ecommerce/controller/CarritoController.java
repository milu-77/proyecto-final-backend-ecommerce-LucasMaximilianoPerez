package com.techlab.ecommerce.controller;

import com.techlab.ecommerce.dtos.response.CarritoResponseDTO;
import com.techlab.ecommerce.model.*;
import com.techlab.ecommerce.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carritos")
@CrossOrigin(origins = "http://localhost:3000")
public class CarritoController {
    @Autowired
    private CarritoService carritoService;
    @GetMapping
    public List<CarritoResponseDTO> listar() {

        return carritoService.listarTodos().stream()
                .map(CarritoResponseDTO::fromCarrito)
                .toList();
    }

    @GetMapping("/{id}")
    public CarritoResponseDTO getUserID(@PathVariable Long id) {
        Optional<Carrito> protoCarrito=carritoService.getByID(id);
        Carrito carrito = protoCarrito.orElseThrow(()->new RuntimeException("Carrito no encontrad"));
        return CarritoResponseDTO.fromCarrito(carrito);
    }
    @GetMapping("/usuario/{id}")
    public List<Carrito> getUserByIdUsuario(@PathVariable Long id) {
        return carritoService.getByIdUsuario(id);
    }
    @PostMapping
    public Carrito crear(@RequestBody Usuario producto) {
        return carritoService.guardar(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrito> actualizar(@PathVariable Long id, @RequestBody Producto datos) {
        Carrito actualizado = carritoService.actualizar(id, datos);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /productos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = carritoService.eliminar(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
