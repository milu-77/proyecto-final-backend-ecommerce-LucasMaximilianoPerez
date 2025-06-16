package com.techlab.ecommerce.controller;

import com.techlab.ecommerce.service.PedidoService;
import com.techlab.ecommerce.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductoController {
    @Autowired
    private ProductoService productoService;
}
