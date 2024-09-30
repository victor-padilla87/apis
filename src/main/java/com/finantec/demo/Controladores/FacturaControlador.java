/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finantec.demo.Controladores;

import com.finantec.demo.Modelos.Factura;
import com.finantec.demo.Servicios.FacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaControlador {

    @Autowired
    private FacturaServicio facturaServicio;

    // Insertar una nueva factura
    @PostMapping
    public ResponseEntity<Factura> insertarFactura(@RequestBody Factura factura) {
        Factura nuevaFactura = facturaServicio.agregarFactura(factura);
        return new ResponseEntity<>(nuevaFactura, HttpStatus.CREATED);
    }

    // Listar todas las facturas
    @GetMapping
    public ResponseEntity<List<Factura>> listarFacturas() {
        List<Factura> facturas = facturaServicio.obtenerTodasLasFacturas();
        return new ResponseEntity<>(facturas, HttpStatus.OK);
    }

    // Obtener una factura por ID
    @GetMapping("/{id}")
    public ResponseEntity<Factura> obtenerFacturaPorId(@PathVariable int id) {
        Factura factura = facturaServicio.obtenerFacturaPorId(id);
        return new ResponseEntity<>(factura, HttpStatus.OK);
    }

    // Actualizar una factura existente
    @PutMapping("/{id}")
    public ResponseEntity<Factura> actualizarFactura(@PathVariable int id, @RequestBody Factura facturaActualizada) {
        Factura factura = facturaServicio.actualizarFactura(id, facturaActualizada);
        return new ResponseEntity<>(factura, HttpStatus.OK);
    }

    // Eliminar una factura por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFactura(@PathVariable int id) {
        facturaServicio.eliminarFactura(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
