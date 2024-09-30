/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finantec.demo.Servicios;

import com.finantec.demo.Modelos.Cliente;
import com.finantec.demo.Repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicios {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    // Método para obtener todos los clientes
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepositorio.findAll();
    }

    // Método para obtener un cliente por su ID
    public Cliente obtenerClientePorId(Long id) {
        Optional<Cliente> cliente = clienteRepositorio.findById(id);
        if (cliente.isPresent()) {
            return cliente.get();
        } else {
            throw new IllegalArgumentException("Cliente no encontrado con ID: " + id);
        }
    }

    // Método para agregar un nuevo cliente
    public Cliente agregarCliente(Cliente cliente) {
        if (cliente.getNombre() == null || cliente.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacío.");
        }
        return clienteRepositorio.save(cliente);
    }

    // Método para actualizar un cliente
    public Cliente actualizarCliente(Long id, Cliente clienteActualizado) {
        Cliente clienteExistente = obtenerClientePorId(id);
        clienteExistente.setNombre(clienteActualizado.getNombre());
        clienteExistente.setEmail(clienteActualizado.getEmail());
        // Actualiza otros atributos si es necesario
        return clienteRepositorio.save(clienteExistente);
    }

    // Método para eliminar un cliente por su ID
    public void eliminarCliente(Long id) {
        Cliente cliente = obtenerClientePorId(id);
        clienteRepositorio.delete(cliente);
    }
}
