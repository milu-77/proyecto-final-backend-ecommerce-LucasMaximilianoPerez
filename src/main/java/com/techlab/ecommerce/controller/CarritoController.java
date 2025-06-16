package com.techlab.ecommerce.controller;

import com.techlab.ecommerce.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carritos")
@CrossOrigin(origins = "http://localhost:3000")
public class CarritoController {
    @Autowired
    private CarritoService carritoService;
}
