package com.techlab.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "producto")
@Getter
@Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private Double precio;
    private Integer stock;
    private String descripcion;
    private String url;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    Producto (){

    }
}
