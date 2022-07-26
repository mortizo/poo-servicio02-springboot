/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ups.books.backend.model.repository;

import com.ups.books.backend.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author UPS
 */
public interface LibroRepository extends JpaRepository<Libro, Long>{
    
}
