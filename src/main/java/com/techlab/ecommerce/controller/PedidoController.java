package com.techlab.ecommerce.controller;

import com.techlab.ecommerce.dtos.response.CarritoResponse;
import com.techlab.ecommerce.model.Pedido;
import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.model.Usuario;
import com.techlab.ecommerce.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "http://localhost:3000")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<CarritoResponse> listar() {

        return pedidoService.listarTodos().stream()
                .map(CarritoResponse::fromPedido)
                .toList();
    }

    @GetMapping("/{id}")
    public CarritoResponse getPedidoID(@PathVariable Long id) {

        return CarritoResponse.fromPedido( pedidoService.getByID(id) );
    }
    @GetMapping("/usuario/{id}")
    public List<CarritoResponse>getPedidosByIdUser(@PathVariable Long id) {
        return pedidoService.getByIdUser(id).stream()
                .map(CarritoResponse::fromPedido)
                .toList();
    }

    @PostMapping
    public void crear(@RequestBody Pedido producto) {



          pedidoService.guardar(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> actualizar(@PathVariable Long id, @RequestBody Producto datos) {
        Pedido actualizado = pedidoService.actualizar(id, datos);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /productos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = pedidoService.eliminar(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


