/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finantec.demo.Servicios;

import com.finantec.demo.Modelos.Factura;
import com.finantec.demo.Repositorios.FacturaRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServicio {

    @Autowired
    private FacturaRepositorio facturaRepositorio;

    // Obtener todas las facturas
    public List<Factura> obtenerTodasLasFacturas() {
        return facturaRepositorio.findAll();
    }

    // Obtener una factura por ID
    public Factura obtenerFacturaPorId(int id) {
        return facturaRepositorio.findById(id).orElseThrow(() -> 
            new IllegalArgumentException("Factura no encontrada con ID: " + id));
    }

    // Agregar una nueva factura
    @Transactional
    public Factura agregarFactura(Factura factura) {
        if (factura.getId_cliente() == null || factura.getListaProductos() == null || factura.getListaProductos().isEmpty()) {
            throw new IllegalArgumentException("La factura debe estar asociada a un cliente y contener productos.");
        }
        return facturaRepositorio.save(factura);
    }

    // Actualizar una factura existente
    @Transactional
    public Factura actualizarFactura(int id, Factura facturaActualizada) {
        Factura factura = obtenerFacturaPorId(id);
        factura.setId_cliente(facturaActualizada.getId_cliente());
        factura.setFecha(facturaActualizada.getFecha());
        factura.setTotal(facturaActualizada.getTotal());
        factura.setForma_pago(facturaActualizada.getForma_pago());
        factura.setEstado_factura(facturaActualizada.getEstado_factura());
        return facturaRepositorio.save(factura);
    }

    // Eliminar una factura por ID
    public void eliminarFactura(int id) {
        facturaRepositorio.deleteById(id);
    }
    
    
}
