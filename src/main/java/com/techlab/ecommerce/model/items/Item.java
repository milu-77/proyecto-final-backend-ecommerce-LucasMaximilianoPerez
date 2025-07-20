package com.techlab.ecommerce.model.items;

import com.techlab.ecommerce.model.Producto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "item")
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true)
    private Integer cantidad;
    @Column(nullable = true)
    private Double  precio;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    Producto producto;

}
