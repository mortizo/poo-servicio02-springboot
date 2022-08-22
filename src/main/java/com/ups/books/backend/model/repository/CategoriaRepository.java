/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ups.books.backend.model.repository;

import com.ups.books.backend.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author UPS
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
    
}
