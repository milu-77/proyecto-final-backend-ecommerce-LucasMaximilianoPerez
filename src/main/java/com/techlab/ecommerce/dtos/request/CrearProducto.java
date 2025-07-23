package com.techlab.ecommerce.dtos.request;

import com.techlab.ecommerce.model.Categoria;
import com.techlab.ecommerce.model.Producto;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@Data
@Getter
@Setter
public class CrearProducto {
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @Size(max = 255, message = "La descripción es muy larga")
    private String descripcion;
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
    @NotNull(message = "El precio es obligatorio")
    private Double precio;
    @URL(message = "La imagen debe ser una URL válida")
    private String url;
    @Min(value = 0, message = "El stock no puede ser negativo")
    @NotNull(message = "El Stock es obligatorio")
    private Integer stock;
    @NotNull(message = "El Stock es obligatorio")
    private Long categoriaId;


    public Producto toProducto() {
        return new Producto( this.nombre,this.descripcion,this.precio,this.stock,this.url);
    }
}
