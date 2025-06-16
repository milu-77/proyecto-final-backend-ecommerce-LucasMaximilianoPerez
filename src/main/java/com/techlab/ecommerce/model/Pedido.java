package com.techlab.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime fecha;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemCarrito> items;

    private Double total;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
     Usuario usuario;
}
