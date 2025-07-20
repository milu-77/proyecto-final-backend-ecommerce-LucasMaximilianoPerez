package com.techlab.ecommerce.dtos.response;

import com.techlab.ecommerce.model.Usuario;
import lombok.Data;

@Data
public class UsuarioResponse {
    private String username;
    private String pass;
    private String mail;

    public static UsuarioResponse fromUsuario(Usuario usuario) {
        UsuarioResponse dto = new UsuarioResponse();
        dto.setUsername(usuario.getUsername());
        dto.setPass(usuario.getPass());
        dto.setMail(usuario.getMail());

        return dto;
    }
}
