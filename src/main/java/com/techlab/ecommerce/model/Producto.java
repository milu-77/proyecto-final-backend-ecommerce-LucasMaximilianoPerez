package com.techlab.ecommerce.model;

import com.techlab.ecommerce.dtos.request.CrearProducto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "producto")
@Table(name = "producto")
@Getter
@Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;
    private Double precio;
    @Column(length = 1000) // Ajusta según necesidad
    private String url;
    private Integer stock;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    @Column(name = "deleted", nullable = false)
    private boolean deleted = false; // Soft delete flag

    Producto (){

    }
    public Producto(String nombre, String descripcion, Double precio, Integer stock, String url){

        this.nombre=nombre;
        this.descripcion=descripcion;
        this.precio=precio;
        this.stock = stock;
        this.url=url;
    }
    public Producto(Integer id,String nombre, String descripcion, Double precio, Integer stock, String url){
        this.id=id;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.precio=precio;
        this.stock = stock;
        this.url=url;
    }

    public Producto actualizar(Long id,CrearProducto datos) {
        return new Producto(Math.toIntExact(id),datos.getNombre(),datos.getDescripcion(),datos.getPrecio(),datos.getStock() ,datos.getUrl()        );
    }


}
