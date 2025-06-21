package com.techlab.ecommerce.repository;

import com.techlab.ecommerce.model.Carrito;
import com.techlab.ecommerce.model.ItemCarrito;
import com.techlab.ecommerce.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository  extends JpaRepository<Pedido, Long> {
    List<Pedido> findByUsuario_Id(Long id);


}
