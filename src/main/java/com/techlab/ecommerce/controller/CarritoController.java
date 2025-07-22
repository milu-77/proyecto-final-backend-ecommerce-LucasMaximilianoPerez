package com.techlab.ecommerce.controller;

import com.techlab.ecommerce.dtos.request.CrearCarrito;
import com.techlab.ecommerce.dtos.request.CrearProducto;
import com.techlab.ecommerce.dtos.response.AcceptResponse;
import com.techlab.ecommerce.dtos.response.CarritoResponse;
import com.techlab.ecommerce.exception.ErrorResponse;
import com.techlab.ecommerce.model.*;
import com.techlab.ecommerce.service.CarritoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carritos")
@CrossOrigin(origins = "http://localhost:3000")
public class CarritoController {
    @Autowired
    private CarritoService carritoService;


    @GetMapping
    public List<CarritoResponse> listar() {

        return carritoService.listarTodos().stream()
                .map(CarritoResponse::fromCarrito)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserID(
            @PathVariable
            @Min(value = 1, message = "El ID debe ser mayor o igual a 1 ")
            Long id)
    {
        try{
             Carrito  carrito = carritoService.getByID(id);
            return ResponseEntity.ok( CarritoResponse.fromCarrito( carrito));
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(),  e.getMessage()));
        }
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?>  getUserByIdUsuario(
            @PathVariable
            @Min(value = 1, message = "El ID debe ser mayor o igual a 1 ")
            Long id)
    {
        try{
            Carrito  carrito = carritoService.getByIdUsuario(id);
            return ResponseEntity.ok( CarritoResponse.fromCarrito( carrito));
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(),  e.getMessage()));
        }





    }

    @PostMapping("/{carritoId}/cerrar")
     public ResponseEntity<?> cerrarCarrito(
            @PathVariable
            @Min(1)
            Long carritoId) //VACIA CARRITO Y CREA PEDIDO
    {
        try {
            carritoService.cerrarCarritoYCrearPedido(carritoId);
            return  ResponseEntity.ok(("Carrito cerrado y pedido creado exitosamente"));

        } catch (Exception e) {
                return  ResponseEntity.badRequest().body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(),  e.getMessage()));
            }
     }
    @PostMapping("/crear")
    public ResponseEntity<?> crearCarrito(
             @Valid
            @RequestBody
             CrearCarrito cliente) //VACIA CARRITO Y CREA PEDIDO
    {
        try {
            carritoService.crearCarrito(cliente);
            return  ResponseEntity.ok("Carrito creado");


        } catch (Exception e) {
        return  ResponseEntity.badRequest().body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(),  e.getMessage()));
    }
     }

    @PutMapping("/{id}")
    @Validated
    public ResponseEntity<?> actualizar(
            @PathVariable
            Long id,
            @Valid
            @RequestBody
            CrearProducto agregarProducto)
    {
        try{

            this.carritoService.actualizar(id,agregarProducto);


            return ResponseEntity
                    .ok()
                    .body(new AcceptResponse(HttpStatus.CREATED.value(), "Producto Actualizado"));

        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
        }





    }

    // DELETE /productos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable
            Long id)
    {
        boolean eliminado = carritoService.eliminar(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
