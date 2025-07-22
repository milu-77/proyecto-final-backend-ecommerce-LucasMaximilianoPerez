package com.techlab.ecommerce.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CrearCarrito {
    @NotBlank(message = "El nombre es obligatorio")
    private String usuario;


}
