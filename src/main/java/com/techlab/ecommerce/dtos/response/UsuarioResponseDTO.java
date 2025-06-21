package com.techlab.ecommerce.dtos.response;

import com.techlab.ecommerce.model.Usuario;
import lombok.Data;

@Data
public class UsuarioResponseDTO {
    private String username;
    private String pass;
    private String mail;

    public static UsuarioResponseDTO fromUsuario(Usuario usuario) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setUsername(usuario.getUsername());
        dto.setPass(usuario.getPass());
        dto.setMail(usuario.getMail());

        return dto;
    }
}
