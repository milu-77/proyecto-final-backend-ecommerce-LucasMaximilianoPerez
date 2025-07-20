package com.techlab.ecommerce.dtos.response;

import com.techlab.ecommerce.model.*;
import com.techlab.ecommerce.model.enums.Estado;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CarritoResponse {
    private LocalDateTime fechaCreacion;
    private Double total;
    private Estado estado;
    private String usuario;
    private List<ItemResponse> productos;


    public static CarritoResponse fromCarrito(Carrito carrito){
        CarritoResponse dto = new CarritoResponse();
        dto.setFechaCreacion(carrito.getFechaCreacion());
        dto.setTotal(carrito.getTotal());
        dto.setEstado(carrito.getEstado());
        dto.setUsuario(carrito.getUsuario().getUsername());
        dto.setProductos(carrito.getItems().stream()
                .map(ItemResponse::fromItem)
                .collect(Collectors.toList()));
        return dto;
    }
    public static CarritoResponse fromPedido(Pedido pedido){
        CarritoResponse dto = new CarritoResponse();
        dto.setFechaCreacion(pedido.getFechaCreacion());
        dto.setTotal(pedido.getTotal());
        dto.setEstado(pedido.getEstado());
        dto.setUsuario(pedido.getUsuario().getUsername());
        dto.setProductos(pedido.getItems().stream()
                .map(ItemResponse::fromItem)
                .collect(Collectors.toList()));
        return dto;
    }


}
