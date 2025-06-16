package com.techlab.ecommerce.repository;

import com.techlab.ecommerce.model.Pedido;
import com.techlab.ecommerce.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
