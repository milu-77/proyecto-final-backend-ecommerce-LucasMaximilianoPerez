package com.techlab.ecommerce.service;

import com.techlab.ecommerce.model.Item;
import com.techlab.ecommerce.model.ItemCarrito;
import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.model.Usuario;
  import com.techlab.ecommerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> listarTodos() {
        return itemRepository.findAll();
    }

    public ItemCarrito getByID(int id) {
        return null;
    }

    public ItemCarrito guardar(Usuario producto) {
        return null;
    }

    public ItemCarrito actualizar(Long id, Producto datos) {
        return null;
    }

    public boolean eliminar(Long id) {
        return false;
    }
}
