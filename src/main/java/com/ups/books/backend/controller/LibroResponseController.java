/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ups.books.backend.controller;

import com.ups.books.backend.controller.response.InfoRest;
import com.ups.books.backend.controller.response.LibroResponse;
import com.ups.books.backend.model.Libro;
import com.ups.books.backend.service.LibroService;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author morti
 */
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/v1")
public class LibroResponseController {
    
    	@Autowired
	private LibroService libroService;
        private static final Logger log = LoggerFactory.getLogger(CategoriaResponseController.class);
	
	@GetMapping("/libros")
	public ResponseEntity<LibroResponse> consulta(){
            log.info("Inicio del método consulta()");            
            try{
                var categoriaResponse=this.libroService.consultar();                
                categoriaResponse.getInfoList().add(new InfoRest(1,"Respuesta Ok",1));
                return new ResponseEntity<>(categoriaResponse, HttpStatus.OK);
            }catch(Exception e1){
                var categoriaResponse = new LibroResponse();            
                var infoList = new ArrayList<InfoRest>();
                infoList.add(new InfoRest(2,e1.getMessage(),0));
                categoriaResponse.setInfoList(infoList);
                return new ResponseEntity<>(categoriaResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }
	}
        
        @GetMapping("/libros/{id}")
	public ResponseEntity<LibroResponse> consultaPorId(@PathVariable Long id){
            log.info("Inicio del método consultaPorId()");            
            try{
                var categoriaResponse=this.libroService.buscarPorId(id);
                categoriaResponse.getInfoList().add(new InfoRest(1,"Respuesta Ok",1));
                return new ResponseEntity<>(categoriaResponse, HttpStatus.OK);
            }catch(Exception e1){
                var categoriaResponse = new LibroResponse();            
                var infoList = new ArrayList<InfoRest>();
                infoList.add(new InfoRest(2,e1.getMessage(),0));
                categoriaResponse.setInfoList(infoList);
                return new ResponseEntity<>(categoriaResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }
	}
        
        @PostMapping("/libros")
	public ResponseEntity<LibroResponse> crear(@RequestBody Libro categoria){
            log.info("Inicio del método crear(Categoria categoria)");            
            try{
                var categoriaResponse=this.libroService.crear(categoria);
                categoriaResponse.getInfoList().add(new InfoRest(1,"Respuesta Ok",1));
                return new ResponseEntity<>(categoriaResponse, HttpStatus.CREATED);
            }catch(Exception e1){                
                var categoriaResponse = new LibroResponse();            
                var infoList = new ArrayList<InfoRest>();
                infoList.add(new InfoRest(2,e1.getMessage(),0));
                categoriaResponse.setInfoList(infoList);                
                return new ResponseEntity<>(categoriaResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

	
	
	@PutMapping("/libros/{id}")
	public ResponseEntity<LibroResponse> actualizar(@RequestBody Libro categoria, @PathVariable Long id){
            log.info("Inicio del método actualizar()");            
            try{
                var categoriaResponse=this.libroService.modificar(categoria, id);
                categoriaResponse.getInfoList().add(new InfoRest(1,"Respuesta Ok",1));
                return new ResponseEntity<>(categoriaResponse, HttpStatus.OK);
            }catch(Exception e1){
                var categoriaResponse = new LibroResponse();            
                var infoList = new ArrayList<InfoRest>();
                infoList.add(new InfoRest(2,e1.getMessage(),0));
                categoriaResponse.setInfoList(infoList);
                return new ResponseEntity<>(categoriaResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }	
	}
	
	@DeleteMapping("/libros/{id}")
	public ResponseEntity<LibroResponse> eliminar(@PathVariable Long id){
            log.info("Inicio del método eliminar()");            
            try{
                var categoriaResponse=this.libroService.eliminar(id);
                categoriaResponse.getInfoList().add(new InfoRest(1,"Respuesta Ok",1));
                return new ResponseEntity<>(categoriaResponse, HttpStatus.OK);
            }catch(Exception e1){
                var categoriaResponse = new LibroResponse();            
                var infoList = new ArrayList<InfoRest>();
                infoList.add(new InfoRest(2,e1.getMessage(),0));
                categoriaResponse.setInfoList(infoList);
                return new ResponseEntity<>(categoriaResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }
	}
    
}
