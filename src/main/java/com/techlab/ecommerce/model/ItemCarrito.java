package com.techlab.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ItemCarrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    Producto producto;
    @ManyToOne
    @JoinColumn(name = "carrito_id")
    private Carrito carrito;
    private int cantidad;
}
