package com.techlab.ecommerce.repository;

import com.techlab.ecommerce.model.ItemCarrito;
import com.techlab.ecommerce.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository  extends JpaRepository<Pedido, Long> {
}
