package com.techlab.ecommerce.controller;

import com.techlab.ecommerce.service.CategoriaService;
import com.techlab.ecommerce.service.ItemCarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itemcarritos")
@CrossOrigin(origins = "http://localhost:3000")
public class ItemCarritoController {
    @Autowired
    private ItemCarritoService itemCarritoService;
}
