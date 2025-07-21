package com.techlab.ecommerce.model.items;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.techlab.ecommerce.dtos.request.CrearProducto;
import com.techlab.ecommerce.model.Carrito;
import com.techlab.ecommerce.model.Producto;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("carrito")
public class ItemCarrito extends Item {

    @ManyToOne
    @JoinColumn(name = "carrito_id")
    @JsonBackReference
    private Carrito carrito;


    public ItemCarrito(Carrito carrito, Producto producto) {

        super(producto);
        this.carrito = carrito;
    }

    public ItemCarrito() {

    }

    public ItemCarrito(
            Carrito carrito,
            Producto producto,
            @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
            @NotNull(message = "El precio es obligatorio")
            Double precio,
            @Min(value = 0, message = "El stock no puede ser negativo")
            @NotNull(message = "El Stock es obligatorio")
            Integer stock) {
        this.setPrecio(precio);
        this.setCantidad(stock);
        this.carrito = carrito;
        this.producto = producto;


    }
}

