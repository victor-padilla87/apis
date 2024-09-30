/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finantec.demo.servicios;

import com.finantec.demo.modelos.Usuario;
import com.finantec.demo.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    // Método para registrar un nuevo usuario
    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    // Método para autenticar un usuario
    public Usuario autenticarUsuario(String email, String password) {
        return usuarioRepositorio.findByEmailAndPassword(email, password);
    }

    // Método para obtener todos los usuarios
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepositorio.findAll();
    }

    // Método para obtener un usuario por su ID
    public Usuario obtenerUsuarioPorId(int id) {
        return usuarioRepositorio.findById(id).orElse(null);
    }

    // Método para actualizar un usuario
    public Usuario actualizarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    // Método para eliminar un usuario
    public void eliminarUsuario(int id) {
        usuarioRepositorio.deleteById(id);
    }
}
