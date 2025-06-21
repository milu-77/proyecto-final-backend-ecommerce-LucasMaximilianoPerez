package com.techlab.ecommerce.service;

import com.techlab.ecommerce.model.Carrito;
import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.model.Usuario;
import com.techlab.ecommerce.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoService {
    @Autowired
    private CarritoRepository carritoRepository;

    public List<Carrito> listarTodos() {
        return carritoRepository.findAll();
    }

    public Optional<Carrito> getByID(Long id) {
        return carritoRepository.findById(id);
    }

    public Carrito guardar(Usuario producto) {
        return null;
    }

    public Carrito actualizar(Long id, Producto datos) {
        return null;
    }

    public boolean eliminar(Long id) {
        return false;
    }

    public List<Carrito> getByIdUsuario(Long id) {
        return carritoRepository.findByUsuario_Id(id);
    }
}
