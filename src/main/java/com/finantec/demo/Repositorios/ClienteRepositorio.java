/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finantec.demo.Repositorios;

import com.finantec.demo.Modelos.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    // Puedes agregar consultas personalizadas si lo necesitas, pero las operaciones CRUD básicas ya están cubiertas por JpaRepository
    Cliente findByEmail(String email);
}
