package com.techlab.ecommerce.controller;

import com.techlab.ecommerce.service.CarritoService;
import com.techlab.ecommerce.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;
}
