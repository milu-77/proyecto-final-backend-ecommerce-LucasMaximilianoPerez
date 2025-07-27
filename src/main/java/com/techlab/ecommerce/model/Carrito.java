package com.techlab.ecommerce.model;

import com.techlab.ecommerce.model.enums.EstadoCarrito;
import com.techlab.ecommerce.model.items.Item;
import com.techlab.ecommerce.model.items.ItemCarrito;
import com.techlab.ecommerce.model.items.ItemPedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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



    public Carrito() {
    }

    public Carrito(Usuario usuario) {
        this.usuario=usuario;
    }

    public void agregarItem(Item item) {
            this.setTotal(getTotal()+(item.getPrecio()*item.getCantidad()));
           this.items.add((ItemCarrito) item);



    }

    public boolean existeItemPorNombreProducto(String nombreProducto) {
        return items.stream()
                .anyMatch(item ->
                        item.getProducto() != null &&
                                nombreProducto.equalsIgnoreCase(nombreProducto)
                );
    }

    public void actualizarItem(ItemCarrito itemcarrito) {
        items.stream()
                .filter(item -> item.getProducto() != null
                        && item.getProducto().getNombre().equalsIgnoreCase(itemcarrito.getProducto().getNombre()))
                .findFirst()
                .ifPresent(item -> {
                    // Actualizar los valores del ítem encontrado
                    item.setCantidad(itemcarrito.getCantidad());
                    item.setPrecio(itemcarrito.getPrecio() );
                });
    }

    public ArrayList<ItemPedido> convertirItemPedido(Pedido pedido) {
        return this.items.stream()
                .map(itemCarrito -> new ItemPedido(itemCarrito, pedido))
                .collect(Collectors.toCollection(ArrayList::new));

    }
    public Double getTotal(){
        return items.stream()
                .mapToDouble(itemCarrito -> itemCarrito.getCantidad() * itemCarrito.getPrecio())
                .sum();
    }

    public void quitarUsuario() {
        this.usuario=null;
    }
}
