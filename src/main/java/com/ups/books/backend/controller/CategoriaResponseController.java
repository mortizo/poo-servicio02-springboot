package com.ups.books.backend.controller;

import com.ups.books.backend.controller.response.CategoriaResponse;
import com.ups.books.backend.controller.response.InfoRest;
import com.ups.books.backend.model.Categoria;
import com.ups.books.backend.service.CategoriaService;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/v1")
public class CategoriaResponseController {
	
	@Autowired
	private CategoriaService categoriaService;
        private static final Logger log = LoggerFactory.getLogger(CategoriaResponseController.class);
	
	@GetMapping("/categorias")
	public ResponseEntity<CategoriaResponse> consulta(){
            log.info("Inicio del método consulta()");   
            try{
                var categoriaResponse=this.categoriaService.consultar();                
                categoriaResponse.getInfoList().add(new InfoRest(1,"Respuesta Ok",1));
                return new ResponseEntity<>(categoriaResponse, HttpStatus.OK);
            }catch(Exception e1){
                var categoriaResponse = new CategoriaResponse();            
                var infoList = new ArrayList<InfoRest>();
                infoList.add(new InfoRest(2,e1.getMessage(),0));
                categoriaResponse.setInfoList(infoList);
                return new ResponseEntity<>(categoriaResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }
	}
        
        @GetMapping("/categorias/{id}")
	public ResponseEntity<CategoriaResponse> consultaPorId(@PathVariable Long id){
            log.info("Inicio del método consultaPorId()");            
            try{
                var categoriaResponse=this.categoriaService.buscarPorId(id);
                categoriaResponse.getInfoList().add(new InfoRest(1,"Respuesta Ok",1));
                return new ResponseEntity<>(categoriaResponse, HttpStatus.OK);
            }catch(Exception e1){
                var categoriaResponse = new CategoriaResponse();            
                var infoList = new ArrayList<InfoRest>();
                infoList.add(new InfoRest(2,e1.getMessage(),0));
                categoriaResponse.setInfoList(infoList);
                return new ResponseEntity<>(categoriaResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }
	}
        
   
        
        
        
        @PostMapping("/categorias")
	public ResponseEntity<CategoriaResponse> crear(@RequestBody Categoria categoria){
            log.info("Inicio del método crear(Categoria categoria)");            
            try{
                var categoriaResponse=this.categoriaService.crear(categoria);
                categoriaResponse.getInfoList().add(new InfoRest(1,"Respuesta Ok",1));
                return new ResponseEntity<>(categoriaResponse, HttpStatus.CREATED);
            }catch(Exception e1){                
                var categoriaResponse = new CategoriaResponse();            
                var infoList = new ArrayList<InfoRest>();
                infoList.add(new InfoRest(2,e1.getMessage(),0));
                categoriaResponse.setInfoList(infoList);                
                return new ResponseEntity<>(categoriaResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
	
	@PutMapping("/categorias/{id}")
	public ResponseEntity<CategoriaResponse> actualizar(@RequestBody Categoria categoria, @PathVariable Long id){
            log.info("Inicio del método actualizar()");            
            try{
                var categoriaResponse=this.categoriaService.modificar(categoria, id);
                categoriaResponse.getInfoList().add(new InfoRest(1,"Respuesta Ok",1));
                return new ResponseEntity<>(categoriaResponse, HttpStatus.OK);
            }catch(Exception e1){
                var categoriaResponse = new CategoriaResponse();            
                var infoList = new ArrayList<InfoRest>();
                infoList.add(new InfoRest(2,e1.getMessage(),0));
                categoriaResponse.setInfoList(infoList);
                return new ResponseEntity<>(categoriaResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }	
	}
	
	@DeleteMapping("/categorias/{id}")
	public ResponseEntity<CategoriaResponse> eliminar(@PathVariable Long id){
            log.info("Inicio del método eliminar()");   
            var auth = SecurityContextHolder.getContext().getAuthentication();
            log.info("Usuario: ",auth.getPrincipal(),auth.getAuthorities());
            try{
                var categoriaResponse=this.categoriaService.eliminar(id);
                categoriaResponse.getInfoList().add(new InfoRest(1,"Respuesta Ok",1));
                return new ResponseEntity<>(categoriaResponse, HttpStatus.OK);
            }catch(Exception e1){
                var categoriaResponse = new CategoriaResponse();            
                var infoList = new ArrayList<InfoRest>();
                infoList.add(new InfoRest(2,e1.getMessage(),0));
                categoriaResponse.setInfoList(infoList);
                return new ResponseEntity<>(categoriaResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }
	}
 
}