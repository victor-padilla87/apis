/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finantec.demo.controladores;

import com.finantec.demo.modelos.Usuario;
import com.finantec.demo.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    // Endpoint para autenticar usuario
    @PostMapping("/autenticar")
    public Usuario autenticarUsuario(@RequestParam String email, @RequestParam String password) {
        return usuarioServicio.autenticarUsuario(email, password);
    }

    // Endpoint para insertar un nuevo usuario
    @PostMapping("/insertar")
    public Usuario insertarUsuario(@RequestBody Usuario usuario) {
        return usuarioServicio.registrarUsuario(usuario);
    }

    // Endpoint para listar todos los usuarios
    @GetMapping("/listar")
    public List<Usuario> listarUsuarios() {
        return usuarioServicio.obtenerTodosLosUsuarios();
    }

    // Endpoint para actualizar un usuario existente
    @PutMapping("/actualizar/{id}")
    public Usuario actualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        usuario.setId(id); // Aseguramos que el ID sea el correcto
        return usuarioServicio.actualizarUsuario(usuario);
    }

    // Endpoint para eliminar un usuario por su ID
    @DeleteMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable int id) {
        usuarioServicio.eliminarUsuario(id);
        return "Usuario eliminado correctamente";
    }
}
