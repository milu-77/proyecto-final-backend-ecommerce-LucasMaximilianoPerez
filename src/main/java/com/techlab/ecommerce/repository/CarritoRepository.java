package com.techlab.ecommerce.repository;

import com.techlab.ecommerce.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {
     Optional<Carrito> findByUsuario_Id(Long id);
}
