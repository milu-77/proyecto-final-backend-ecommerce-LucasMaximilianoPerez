package com.techlab.ecommerce.dtos.response;

import com.techlab.ecommerce.model.ItemCarrito;
import com.techlab.ecommerce.model.ItemPedido;
import lombok.Data;

@Data
public class ItemResponseDTO {
    private String nombre;
    private Double precio;
    private Integer cantidad;

    public static ItemResponseDTO fromItem(ItemCarrito item){
        ItemResponseDTO dto = new ItemResponseDTO();
        dto.setNombre(item.getProducto().getNombre());
        dto.setCantidad(item.getCantidad());
        dto.setPrecio(item.getProducto().getPrecio());
        return dto;
    }
    public static ItemResponseDTO fromItem(ItemPedido item){
        ItemResponseDTO dto = new ItemResponseDTO();
        dto.setNombre(item.getProducto().getNombre());
        dto.setCantidad(item.getCantidad());
        dto.setPrecio(item.getProducto().getPrecio());
        return dto;
    }



}
