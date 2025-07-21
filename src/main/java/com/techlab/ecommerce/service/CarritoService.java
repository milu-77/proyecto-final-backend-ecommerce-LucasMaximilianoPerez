package com.techlab.ecommerce.service;

import com.techlab.ecommerce.dtos.request.CrearProducto;
import com.techlab.ecommerce.exception.ProductServiceException;
import com.techlab.ecommerce.exception.carritoServiceException;
import com.techlab.ecommerce.model.Carrito;
import com.techlab.ecommerce.model.Pedido;
import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.model.Usuario;
import com.techlab.ecommerce.model.enums.EstadoCarrito;
import com.techlab.ecommerce.model.enums.EstadoPedido;
import com.techlab.ecommerce.model.items.ItemCarrito;
import com.techlab.ecommerce.model.items.ItemPedido;
import com.techlab.ecommerce.repository.CarritoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarritoService {
    @Autowired
    private CarritoRepository carritoRepository;
    @Autowired
    private ProductoService productoService;
    @Autowired
    ItemService itemService;
    @Autowired
    private PedidoService pedidoService;

    public List<Carrito> listarTodos() {
        return carritoRepository.findAll();
    }

    public  Carrito getByID(Long id)
    {


        Optional<Carrito> carrito = this.carritoRepository.findById( id);
        if(carrito.isPresent()){

                return carrito.get();

        }else{
            throw new ProductServiceException("El producto con nombre: '" + id+ " no existe");
        }
















    }

    public Carrito guardar(Usuario producto) {
        return null;
    }
    @Transactional
    public void actualizar(
            Long id,
            @Valid
            CrearProducto datos)
    {
        // 1. Validar stock
        Producto producto = productoService.getByNombre(datos.getNombre());
        if (datos.getStock() > producto.getStock()) {
            throw new carritoServiceException("Stock insuficiente");
        }
        // 2. Obtener carrito
        Carrito carrito = this.getByID(id);
        // 3. Actualizar stock del producto (si es necesario)
        producto.setStock(producto.getStock() - datos.getStock());
        productoService.guardar( producto);  // ¡Importante guardar!
        // 4. Crear o actualizar ítem en el carrito
        ItemCarrito item = new ItemCarrito(carrito, producto, datos.getPrecio(), datos.getStock());

        carrito.getItems()
                .stream()
                .filter(i -> i.getProducto().getId().equals(producto.getId()))
                .findFirst()
                .ifPresentOrElse(
                        existingItem -> existingItem.setCantidad(existingItem.getCantidad() + datos.getStock()),
                        () -> carrito.agregarItem(item)
                );
        // 5. Guardar cambios
        carritoRepository.save(carrito);


    }

    public boolean eliminar(Long id) {
        return false;
    }

    public  Carrito getByIdUsuario(Long id) {

        Optional<Carrito> carrito = this.carritoRepository.findByUsuario_Id(id);
        if(carrito.isPresent()){
            return carrito.get();
        }else{
            throw new carritoServiceException("El producto con nombre: '" + id+ " no existe");
        }
    }
    @Transactional
    public void cerrarCarritoYCrearPedido(@Min(1) Long carritoId) {
        // 1. Validar y obtener carrito
        Carrito carrito = this.getByID(carritoId) ;
        // 2. Crear pedido
        Pedido pedido = new Pedido();
        pedido.setUsuario(carrito.getUsuario());
        pedido.setTotal(carrito.getTotal());
        ArrayList<ItemPedido> items =carrito.convertirItemPedido(pedido);
         pedido.setItems(items);
         pedido.setTotal(carrito.getTotal());
         pedido.setEstado(EstadoPedido.EN_PREPARACION);
         carrito.setEstado(EstadoCarrito.CONVERTIDO);

//        pedido.setItems(convertirItemPedido(carrito.getItems(),pedido));
//        pedido.setUsuario(carrito.getUsuario());
         this.pedidoService.guardar(pedido);

    }


}
