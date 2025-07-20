package com.techlab.ecommerce.model.items;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.techlab.ecommerce.model.Carrito;
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
    @JsonBackReference
    private Carrito carrito;

}
