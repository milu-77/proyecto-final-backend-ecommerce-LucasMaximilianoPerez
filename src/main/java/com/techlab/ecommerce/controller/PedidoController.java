package com.techlab.ecommerce.controller;

import com.techlab.ecommerce.service.ItemCarritoService;
import com.techlab.ecommerce.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "http://localhost:3000")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;
}
