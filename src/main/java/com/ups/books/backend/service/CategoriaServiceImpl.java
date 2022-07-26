/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ups.books.backend.service;

import com.ups.books.backend.controller.response.CategoriaResponse;
import com.ups.books.backend.model.Categoria;
import com.ups.books.backend.model.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author UPS
 */
@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Override
    @Transactional(readOnly = true)
    public CategoriaResponse consultar() {
        var categoriaResponse= new CategoriaResponse();
        var categoriaList = (List<Categoria>) this.categoriaRepository.findAll();
        categoriaResponse.setData(categoriaList);
        return categoriaResponse;
    }
    
}
