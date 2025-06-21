package com.techlab.ecommerce.controller;

import com.techlab.ecommerce.dtos.response.ProductoResponseDTO;
import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")
//@CrossOrigin(origins = "http://localhost:3000")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<ProductoResponseDTO> listar() {

        return productoService.listarTodos()
                .stream()
                .map(ProductoResponseDTO::fromProducto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductoResponseDTO getProductoID(@PathVariable Long id) {
        Optional<Producto> optionalProducto = productoService.getByID(id);
        Producto producto = optionalProducto.orElseThrow(
                () -> new RuntimeException("Producto con ID " + id + " no encontrado")
        );
        return ProductoResponseDTO.fromProducto(producto);
    }

    @GetMapping("/categoria/{id}")
    public List<ProductoResponseDTO> getProductoCategoraId(@PathVariable Long id) {
        System.out.println(">>> Buscando producto con Categoria ID: " + id);
        return productoService.listarCategoria(id)
                .stream()
                .map(ProductoResponseDTO::fromProducto)
                .collect(Collectors.toList());





    }

    @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return productoService.guardar(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Long id, @RequestBody Producto datos) {
        Producto actualizado = productoService.actualizar(id, datos);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /productos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = productoService.eliminar(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
