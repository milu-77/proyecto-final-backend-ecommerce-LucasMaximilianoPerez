package com.techlab.ecommerce.dtos.response;

import com.techlab.ecommerce.model.items.Item;
import com.techlab.ecommerce.model.items.ItemCarrito;
import com.techlab.ecommerce.model.items.ItemPedido;
import lombok.Data;

@Data
public class ItemResponse {
    private String nombre;
    private Double precio;
    private Integer cantidad;

    public static ItemResponse fromItem(ItemCarrito item){
        ItemResponse dto = new ItemResponse();
        dto.setNombre(item.getProducto().getNombre());
        dto.setCantidad(item.getCantidad());
        dto.setPrecio(item.getProducto().getPrecio());
        return dto;
    }
    public static ItemResponse fromItem(ItemPedido item){
        ItemResponse dto = new ItemResponse();
        dto.setNombre(item.getProducto().getNombre());
        dto.setCantidad(item.getCantidad());
        dto.setPrecio(item.getProducto().getPrecio());
        return dto;
    }


    public static ItemResponse fromItem(Item item) {
        ItemResponse dto = new ItemResponse();
        dto.setNombre(item.getProducto().getNombre());
        dto.setCantidad(item.getCantidad());
        dto.setPrecio(item.getProducto().getPrecio());
        return dto;
    }
}
