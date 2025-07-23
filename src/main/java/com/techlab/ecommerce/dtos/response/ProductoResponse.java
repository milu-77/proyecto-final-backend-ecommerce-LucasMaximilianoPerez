package com.techlab.ecommerce.dtos.response;

import com.techlab.ecommerce.model.Producto;
import lombok.Data;

import java.util.Optional;

@Data
public class ProductoResponse {
        Integer id;
      String nombre;
      Double precio;
      Integer stock;
      String descripcion;
      String url;

    public static ProductoResponse fromProducto(Producto  producto) {
        ProductoResponse dto = new ProductoResponse();
        dto.id=producto.getId();
        dto.setNombre(producto.getNombre());
        dto.setPrecio(producto.getPrecio());
        dto.setStock(producto.getStock());
        dto.setDescripcion(producto.getDescripcion());
        dto.setUrl(producto.getUrl()); // Ejemplo de URL generada
        return dto;
    }





}
