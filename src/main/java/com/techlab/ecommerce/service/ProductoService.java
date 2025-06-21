package com.techlab.ecommerce.service;

import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public boolean eliminar(Long id) {
        return false;
    }

    public Producto actualizar(Long id, Producto datos) {
        return datos;
    }

    public Producto guardar(Producto producto) {
        return null;
    }

    public Optional<Producto> getByID(Long id) {
        return this.productoRepository.findById( id);
    }

    public List<Producto> listarTodos() {
        return this.productoRepository.findAll();
    }
    public List<Producto> listarCategoria(Long id) {
        return this.productoRepository.findByCategoria_Id(id);
    }
}
