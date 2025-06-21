package com.techlab.ecommerce.service;

import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.model.Usuario;
import com.techlab.ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean eliminar(Long id) {
        return false;
    }

    public Usuario actualizar(Long id, Producto datos) {
        return null;
    }

    public Usuario guardar(Usuario producto) {
        return producto;
    }

    public Optional<Usuario> getByID(Long id) {
        return usuarioRepository.findById(id);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }
}
