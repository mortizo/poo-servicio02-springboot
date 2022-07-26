/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ups.books.backend.service;

import com.ups.books.backend.controller.response.CategoriaResponse;
import com.ups.books.backend.model.Categoria;

/**
 *
 * @author UPS
 */
public interface CategoriaService {
    
    public CategoriaResponse consultar();
    public CategoriaResponse buscarPorId(Long id);
    public CategoriaResponse crear(Categoria categoria);
    public CategoriaResponse modificar(Categoria categoria, Long id);
    public CategoriaResponse eliminar(Long id);
    
    
    
}
