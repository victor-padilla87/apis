/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finantec.demo.servicios;

import com.finantec.demo.modelos.Producto;
import com.finantec.demo.repositorios.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    public Producto crearProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }

    public List<Producto> listarProductos() {
        return productoRepositorio.findAll();
    }

    public Optional<Producto> obtenerProductoPorId(int id) {
        return productoRepositorio.findById(id);
    }

    public Producto actualizarProducto(int id, Producto producto) {
        return productoRepositorio.findById(id).map(p -> {
            p.setNombre(producto.getNombre());
            p.setDescripcion(producto.getDescripcion());
            p.setPrecioCompra(producto.getPrecioCompra());
            p.setPrecioUnitario(producto.getPrecioUnitario());
            p.setCantidad(producto.getCantidad());
            p.setPorcentajeIva(producto.getPorcentajeIva());
            p.setProveedor(producto.getProveedor());
            return productoRepositorio.save(p);
        }).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public void eliminarProducto(int id) {
        productoRepositorio.deleteById(id);
    }
}
