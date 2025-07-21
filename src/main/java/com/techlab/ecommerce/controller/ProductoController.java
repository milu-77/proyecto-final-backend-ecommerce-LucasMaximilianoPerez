package com.techlab.ecommerce.controller;

import com.techlab.ecommerce.dtos.request.CrearProducto;
import com.techlab.ecommerce.dtos.response.ProductoResponse;
import com.techlab.ecommerce.dtos.response.AcceptResponse;
import com.techlab.ecommerce.exception.ErrorResponse;
import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.service.ProductoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public List<ProductoResponse> listar()
    {
        return productoService.listarTodos()
                .stream()
                .filter(producto ->producto.getStock()>0)
                .map(ProductoResponse::fromProducto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @Validated
    public ResponseEntity<?>  getProductoID(
            @PathVariable
            @Min(value = 1, message = "El ID debe ser mayor o igual a 1 ")
            Long id)
    {
        try{
            Producto producto = productoService.getByID(id);
            return ResponseEntity.ok( ProductoResponse.fromProducto( producto));
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(),  e.getMessage()));
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> getProductonombre(
            @RequestParam
            String nombre )
    {
        try{
            Producto producto = productoService.getByNombre(nombre);
            return ResponseEntity.ok( ProductoResponse.fromProducto( producto));
        }catch (Exception e) {
            return  ResponseEntity.badRequest()
                    .body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(),  e.getMessage()));
        }
    }

    @GetMapping("/categoria/{id}")
    public List<ProductoResponse> getProductoCategoraId(
            @PathVariable Long id)
    {
        System.out.println(">>> Buscando producto con Categoria ID: " + id);
        return productoService.listarCategoria(id)
                .stream()
                .map(ProductoResponse::fromProducto)
                .collect(Collectors.toList());
    }

    @PostMapping
     public ResponseEntity<?> crear(
             @Valid
             @RequestBody
             CrearProducto producto )
    {
        try{
            Optional<Producto> productoGuardado = productoService.guardar(producto);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(productoGuardado.get().getId())
                    .toUri();
            return ResponseEntity.created(location).body(new AcceptResponse(HttpStatus.CREATED.value(), "Producto Agregado"));
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(),  e.getMessage()));
        }
     }

    @PutMapping("/{id}")
     public ResponseEntity<?>  actualizar(
            @PathVariable
            @Min(value = 1, message = "El ID debe ser mayor o igual a 1 ")
            Long id,
            @Valid
            @RequestBody
            CrearProducto  datos)
    {
        try{
            Optional<Producto> productoGuardado = Optional.ofNullable(productoService.actualizar(id, datos));
            return ResponseEntity.ok().body(new AcceptResponse(HttpStatus.CREATED.value(), "Producto Actualizado"));

        } catch (Exception e) {
             return ResponseEntity.badRequest()
                     .body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
        }
    }

    // DELETE /productos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(
            @PathVariable
            @Min(value = 1, message = "El ID debe ser mayor o igual a 1 ")
            Long id) {
        try{
            boolean eliminado = productoService.eliminar(id);
            return ResponseEntity.ok()
                    .body(new AcceptResponse(HttpStatus.CREATED.value(), "Producto Eliminado"));
        } catch (Exception e)
        {
            return ResponseEntity.badRequest()
                    .body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
        }
    }
}
