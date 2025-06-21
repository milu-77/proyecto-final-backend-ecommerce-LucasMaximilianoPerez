package com.techlab.ecommerce.dtos.response;

import com.techlab.ecommerce.model.Producto;
import lombok.Data;

import java.util.Optional;

@Data
public class  ProductoResponseDTO {

      String nombre;
      Double precio;
      Integer stock;
      String descripcion;
      String url;

    public static ProductoResponseDTO fromProducto( Producto  producto) {
        ProductoResponseDTO dto = new ProductoResponseDTO();
        dto.setNombre(producto.getNombre());
        dto.setPrecio(producto.getPrecio());
        dto.setStock(producto.getStock());
        dto.setDescripcion(producto.getDescripcion());
        dto.setUrl("/productos/" + producto.getId()); // Ejemplo de URL generada
        return dto;
    }


}
