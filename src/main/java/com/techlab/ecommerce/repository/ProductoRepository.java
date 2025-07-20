package com.techlab.ecommerce.repository;

import com.techlab.ecommerce.model.Pedido;
import com.techlab.ecommerce.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByCategoria_Id(Long id);


    Optional<Producto> findByNombre(String nombre);
    List<Producto> findByDeletedFalse();
}
