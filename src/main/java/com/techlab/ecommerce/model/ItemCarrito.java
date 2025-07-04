package com.techlab.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("carrito")
public class ItemCarrito extends Item{

    @ManyToOne
    @JoinColumn(name = "carrito_id")
    private Carrito carrito;

}
