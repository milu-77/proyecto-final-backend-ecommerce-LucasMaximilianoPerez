package com.techlab.ecommerce.service;

import com.techlab.ecommerce.model.items.Item;
import com.techlab.ecommerce.model.items.ItemCarrito;
import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.model.Usuario;
  import com.techlab.ecommerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> listarTodos() {
        return itemRepository.findAll();
    }

    public Optional<Item> getByID(Long  id) {
        return itemRepository.findById(id);
    }

    public ItemCarrito guardar(ItemCarrito producto) {
        this.itemRepository.save(producto);
        return null;
    }

    public ItemCarrito actualizar(Long id, Producto datos) {
        return null;
    }

    public boolean eliminar(Long id) {
        return false;
    }

    public List<Item> listarPedidos() {
        return itemRepository.findAllPedidos();
    }
    public List<Item> listarCarritos() {
        return itemRepository.findAllCarritos();
    }
}
