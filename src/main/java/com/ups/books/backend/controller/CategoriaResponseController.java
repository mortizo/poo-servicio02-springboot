package com.ups.books.backend.controller;

import com.ups.books.backend.controller.response.CategoriaResponse;
import com.ups.books.backend.model.Categoria;
import com.ups.books.backend.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
@RestController
@RequestMapping("/v1")
public class CategoriaResponseController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/categorias")
	public ResponseEntity<CategoriaResponse> consulta(){
            var categoriaResponse=this.categoriaService.consultar();
            return new ResponseEntity<>(categoriaResponse, HttpStatus.OK);    
	}
        
        @PostMapping("/categorias")
	public ResponseEntity<CategoriaResponse> crear(@RequestBody Categoria categoria){
            var categoriaResponse=this.categoriaService.crear(categoria);
            return new ResponseEntity<>(categoriaResponse, HttpStatus.OK);    
	}
        
        
}