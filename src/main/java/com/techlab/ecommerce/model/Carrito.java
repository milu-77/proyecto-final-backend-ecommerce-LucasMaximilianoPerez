package com.techlab.ecommerce.model;

import com.techlab.ecommerce.model.enums.EstadoCarrito;
import com.techlab.ecommerce.model.items.ItemCarrito;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "carrito")
@Getter
@Setter
@Table(name = "carrito")

public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaCreacion;
    private Double total;
    private EstadoCarrito estado;

    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL)
    private List<ItemCarrito> items = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "usuario_id") // FK en tabla carrito
    private Usuario usuario; // Dueño del carrito

 }
