/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ups.books.backend.controller;

import com.ups.books.backend.controller.response.CategoriaResponse;
import com.ups.books.backend.model.Categoria;
import com.ups.books.backend.service.CategoriaService;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author morti
 */
public class CategoriaResponseControllerTest {
    
    @InjectMocks
    CategoriaResponseController categoriaResponseController;
    
    @Mock
    private CategoriaService categoriaService;
    
    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        
    }
    
    @Test
    public void crearTest(){
        var request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        var categoria = new Categoria(Long.valueOf("100"), 
                "Categoría Test1", "Descripción de la Categoría1");
        
        when(categoriaService.crear(any(Categoria.class))).thenReturn(new CategoriaResponse());
        
        var response = categoriaResponseController.crear(categoria);
        
        assertThat(response.getStatusCodeValue()).isEqualTo(500);
        
    }
    
}
