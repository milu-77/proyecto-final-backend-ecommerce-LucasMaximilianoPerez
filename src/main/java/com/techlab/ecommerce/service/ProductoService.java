package com.techlab.ecommerce.service;

import com.techlab.ecommerce.dtos.request.CrearProducto;
import com.techlab.ecommerce.exception.ProductServiceException;
import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public boolean eliminar(Long id)
    {
        Optional<Producto> producto = this.productoRepository.findById( id);
        if(producto.isPresent()){
            Producto prod=producto.get();
            if(!prod.isDeleted()){
                prod.setDeleted(true);
                this.productoRepository.save(prod);
                return true;
            }else{
                throw new ProductServiceException("El producto con nombre: '" + id+ " no existe");
            }
        }else{
            throw new ProductServiceException("El producto con nombre: '" + id+ " no existe");
        }


     }

    public Producto  actualizar(Long id, CrearProducto  datos)
    {
        Optional<Producto> producto = this.productoRepository.findById( id);
        if(producto.isPresent()){
            this.productoRepository.save(producto.get().actualizar(id,datos));

            return producto.get();
        }else{
            throw new ProductServiceException("El producto con ID: '" + id+ " no existe");

        }
     }

    public Optional<Producto> guardar(CrearProducto producto)
    {
        if (productoRepository.findByNombre(producto.getNombre()).isPresent()) {
            throw new ProductServiceException("El producto '" + producto.getNombre() + "' ya está registrado");
        }else{
            productoRepository.save(producto.toProducto());
            return productoRepository.findByNombre(producto.getNombre());
        }

    }
    public void guardar(Producto producto)
    {

            productoRepository.save(producto);


    }

    public Producto getByID(Long id)
    {
        Optional<Producto> producto = this.productoRepository.findById( id);
        if(producto.isPresent()){
            if(!producto.get().isDeleted()){
                return producto.get();
            }else{
                throw new ProductServiceException("El producto con nombre: '" + id+ " no existe");
            }
        }else{
            throw new ProductServiceException("El producto con nombre: '" + id+ " no existe");
        }

    }

    public List<Producto> listarTodos()
    {
        return this.productoRepository.findByDeletedFalse();
    }
    public List<Producto> listarCategoria(Long id)
    {
        return this.productoRepository.findByCategoria_Id(id)
                .stream()
                .filter(producto -> !producto.isDeleted())
                .collect(Collectors.toList());

    }

    public Producto getByNombre(String nombre)
    {
        Optional<Producto> producto = this.productoRepository.findByNombre(nombre);
        if(producto.isPresent()){
            if(!producto.get().isDeleted()){
                return producto.get();
            }else{
                throw new ProductServiceException("El producto con nombre: '" + nombre+ " no existe");
            }
        }else{
            throw new ProductServiceException("El producto con nombre: '" + nombre+ " no existe");
        }
    }
}
