package com.techlab.ecommerce.controller;

 import com.techlab.ecommerce.dtos.response.UsuarioResponse;
 import com.techlab.ecommerce.model.Producto;
 import com.techlab.ecommerce.model.Usuario;
 import com.techlab.ecommerce.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.*;

 import java.util.List;
 import java.util.Optional;
 import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:3000")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping
    public List<UsuarioResponse> listar() {
        return usuarioService.listarTodos().stream()
                .map(UsuarioResponse::fromUsuario)
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
     public UsuarioResponse getUserID(@PathVariable  Long id) {
        Optional<Usuario> protoUsuario = usuarioService.getByID(id);
        Usuario usuario = protoUsuario.orElseThrow(() -> new RuntimeException("Producto con ID " + id + " no encontrado"));
        return UsuarioResponse.fromUsuario(usuario);
    }
    @PostMapping
    public Usuario crear(@RequestBody Usuario producto) {
        return usuarioService.guardar(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable Long id, @RequestBody Producto datos) {
        Usuario actualizado = usuarioService.actualizar(id, datos);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /productos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = usuarioService.eliminar(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
