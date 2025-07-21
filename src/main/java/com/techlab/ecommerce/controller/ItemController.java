package com.techlab.ecommerce.controller;

import com.techlab.ecommerce.dtos.response.ItemResponse;
import com.techlab.ecommerce.model.*;
import com.techlab.ecommerce.model.items.Item;
import com.techlab.ecommerce.model.items.ItemCarrito;
import com.techlab.ecommerce.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
@CrossOrigin(origins = "http://localhost:3000")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @GetMapping
    public List<ItemResponse> listar() {
        return itemService.listarTodos()
                .stream()
                .map(ItemResponse::fromItem)
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public ItemResponse getItemID(@PathVariable Long id) {
        Optional<Item> protoItems= itemService.getByID(id);
        Item item = protoItems.orElseThrow(()->new RuntimeException("Iten no encotnrado"));


        return ItemResponse.fromItem(item);
    }
    @GetMapping("/pedidos")
    public List<ItemResponse> getItemPedidos() {
        return itemService.listarPedidos()
                .stream()
                .map(ItemResponse::fromItem)
                .collect(Collectors.toList());


     }
    @GetMapping("/carritos")
    public List<ItemResponse> getItemCarritos() {
        return itemService.listarCarritos()
                .stream()
                .map(ItemResponse::fromItem)
                .collect(Collectors.toList());


    }










    @PostMapping
    public ItemCarrito crear(@RequestBody Usuario producto) {
        return null;
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
