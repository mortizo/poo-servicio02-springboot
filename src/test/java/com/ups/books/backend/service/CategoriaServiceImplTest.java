/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ups.books.backend.service;

import com.ups.books.backend.controller.response.CategoriaResponse;
import com.ups.books.backend.model.Categoria;
import com.ups.books.backend.model.repository.CategoriaRepository;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Mauricio Ortiz Ochoa
 */
public class CategoriaServiceImplTest {
    
    private List<Categoria> categoriaList = new ArrayList<>();
    
    @InjectMocks
    CategoriaServiceImpl service;
    
    @Mock
    CategoriaRepository categoriaRepository;
    
    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        this.cargarCategorias();
    }
    
    @Test
    public void consultarTest(){
        when(categoriaRepository.findAll()).thenReturn(this.categoriaList);
        CategoriaResponse response = service.consultar();
        
        assertEquals(5,response.getData().size());
        verify(this.categoriaRepository,times(1)).findAll();
    }
    
    public void cargarCategorias(){
        categoriaList.add(new Categoria(Long.valueOf("100"), 
                "Categoría Test1", "Descripción de la Categoría1"));
        categoriaList.add(new Categoria(Long.valueOf("200"), 
                "Categoría Test2", "Descripción de la Categoría2"));
        categoriaList.add(new Categoria(Long.valueOf("300"), 
                "Categoría Test3", "Descripción de la Categoría3"));
        categoriaList.add(new Categoria(Long.valueOf("400"), 
                "Categoría Test4", "Descripción de la Categoría4"));
        categoriaList.add(new Categoria(Long.valueOf("500"), 
                "Categoría Test5", "Descripción de la Categoría5"));
    } 
}
