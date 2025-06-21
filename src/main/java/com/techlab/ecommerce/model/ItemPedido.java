package com.techlab.ecommerce.model;

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
    private Pedido pedido;

 }
