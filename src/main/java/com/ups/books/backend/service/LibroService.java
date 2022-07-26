/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ups.books.backend.service;

import com.ups.books.backend.controller.response.LibroResponse;
import com.ups.books.backend.model.Libro;

/**
 *
 * @author morti
 */
public interface LibroService {
    
    public LibroResponse consultar();
    public LibroResponse buscarPorId(Long id);
    public LibroResponse crear(Libro libro);
    public LibroResponse modificar(Libro libro, Long id);
    public LibroResponse eliminar(Long id);
    
}
