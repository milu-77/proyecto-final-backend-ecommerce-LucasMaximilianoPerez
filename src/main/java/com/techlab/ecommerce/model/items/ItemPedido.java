package com.techlab.ecommerce.model.items;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.techlab.ecommerce.model.Pedido;
import com.techlab.ecommerce.model.Producto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

@DiscriminatorValue("pedido")
public class ItemPedido extends Item {

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    @JsonBackReference
    private Pedido pedido;

    public ItemPedido(Producto producto) {
        super(producto);
    }


    public ItemPedido(ItemCarrito itemCarrito, Pedido pedido) {
            super(itemCarrito.getProducto());
            this.pedido=pedido;

    }

    public ItemPedido() {
    }
}
