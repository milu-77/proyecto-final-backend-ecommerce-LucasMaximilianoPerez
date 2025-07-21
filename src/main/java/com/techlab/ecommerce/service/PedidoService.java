package com.techlab.ecommerce.service;

import com.techlab.ecommerce.model.Pedido;
import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.model.Usuario;
 import com.techlab.ecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;


    public boolean eliminar(Long id) {
        return false;
    }

    public Pedido actualizar(Long id, Producto datos) {
        return null;
    }

    public void guardar(Pedido pedido) {
        pedidoRepository.save(pedido);
     }

    public Pedido getByID(Long id) {
        return null;
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public List<Pedido> getByIdUser(Long id) {
       return  pedidoRepository.findByUsuario_Id(id);
    }
}
