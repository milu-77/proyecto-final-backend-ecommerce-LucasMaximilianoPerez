package com.techlab.ecommerce.service;

import com.techlab.ecommerce.exception.ProductServiceException;
import com.techlab.ecommerce.model.Categoria;
import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.model.Usuario;
import com.techlab.ecommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarTodos() {
        return categoriaRepository.findAll();
    }

    public  Categoria  getByID(Long id) {
        Optional<Categoria> categoria =this.categoriaRepository.findById(id);
        if(categoria.isPresent()){
            return categoria.get();
        }else {
            throw new ProductServiceException("La categoria  no existe"+id);
        }

     }

    public Categoria guardar(Usuario producto) {
        return null;
    }

    public Categoria actualizar(Long id, Producto datos) {
        return null;
    }

    public boolean eliminar(Long id) {
        return false;
    }
}
