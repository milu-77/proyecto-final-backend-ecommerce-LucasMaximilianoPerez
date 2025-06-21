package com.techlab.ecommerce.dtos.response;

import com.techlab.ecommerce.model.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CarritoResponseDTO {
    private LocalDateTime fechaCreacion;
    private Double total;
    private Estado estado;
    private String usuario;
    private List<ItemResponseDTO> productos;


    public static CarritoResponseDTO fromCarrito(Carrito carrito){
        CarritoResponseDTO dto = new CarritoResponseDTO();
        dto.setFechaCreacion(carrito.getFechaCreacion());
        dto.setTotal(carrito.getTotal());
        dto.setEstado(carrito.getEstado());
        dto.setUsuario(carrito.getUsuario().getUsername());
        dto.setProductos(carrito.getItems().stream()
                .map(ItemResponseDTO::fromItem)
                .collect(Collectors.toList()));
        return dto;
    }
    public static CarritoResponseDTO fromPedido(Pedido pedido){
        CarritoResponseDTO dto = new CarritoResponseDTO();
        dto.setFechaCreacion(pedido.getFechaCreacion());
        dto.setTotal(pedido.getTotal());
        dto.setEstado(pedido.getEstado());
        dto.setUsuario(pedido.getUsuario().getUsername());
        dto.setProductos(pedido.getItems().stream()
                .map(ItemResponseDTO::fromItem)
                .collect(Collectors.toList()));
        return dto;
    }


}
