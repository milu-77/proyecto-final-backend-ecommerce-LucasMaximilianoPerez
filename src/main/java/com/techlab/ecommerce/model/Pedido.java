package com.techlab.ecommerce.model;

import com.techlab.ecommerce.model.enums.EstadoPedido;
import com.techlab.ecommerce.model.items.ItemPedido;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "pedido")
@Getter
@Setter
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaCreacion;
    private Double total;
    private EstadoPedido estado;
    @OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL)
    private List<ItemPedido> items;


    @ManyToOne
    @JoinColumn(name = "usuario_id")
     Usuario usuario;
}
