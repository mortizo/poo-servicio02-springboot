/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ups.books.backend.service;

import com.ups.books.backend.controller.response.InfoRest;
import com.ups.books.backend.controller.response.LibroResponse;
import com.ups.books.backend.model.Libro;
import com.ups.books.backend.model.repository.LibroRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author morti
 */
@Service
public class LibroServiceImpl implements LibroService{

    @Autowired
    private LibroRepository libroRepository;
    
    @Override
    @Transactional(readOnly = true)
    public LibroResponse consultar() {
        var libroResponse= new LibroResponse();        
        var data = (List<Libro>) this.libroRepository.findAll();
        var infoList = new ArrayList<InfoRest>();
        libroResponse.setData(data);
        libroResponse.setInfoList(infoList);
        return libroResponse;    
    }

    @Override
    @Transactional(readOnly = true)
    public LibroResponse buscarPorId(Long id) {
        var libroResponse= new LibroResponse();        
        var data = new ArrayList<Libro>();
        var infoList = new ArrayList<InfoRest>();
        var libroBuscado = this.libroRepository.findById(id);
        if(libroBuscado.isPresent()){
            data.add(libroBuscado.get());
        }else{
            infoList.add(new InfoRest(1,"Categoria no encontrada",1));
        }
        libroResponse.setData(data);
        libroResponse.setInfoList(infoList);
        return libroResponse;
    }

    @Override
    @Transactional
    public LibroResponse crear(Libro libro) {
        var libroResponse= new LibroResponse(); 
        var data = new ArrayList<Libro>();
        var infoList = new ArrayList<InfoRest>();
        data.add(this.libroRepository.save(libro));
        libroResponse.setData(data);
        libroResponse.setInfoList(infoList);
        return libroResponse;    
    }

    @Override
    @Transactional
    public LibroResponse modificar(Libro libro, Long id) {
        var libroResponse= new LibroResponse();        
        var data = new ArrayList<Libro>();
        var infoList = new ArrayList<InfoRest>();
        var libroBuscado = this.libroRepository.findById(id);
        if(libroBuscado.isPresent()){
            libroBuscado.get().setNombre(libro.getNombre());
            libroBuscado.get().setDescripcion(libro.getDescripcion());
            libroBuscado.get().setCategoria(libro.getCategoria());
            data.add(this.libroRepository.save(libroBuscado.get()));
        }else{
            infoList.add(new InfoRest(1,"Categoria no encontrada",1));
        }
        libroResponse.setData(data);
        libroResponse.setInfoList(infoList);
        return libroResponse;  
    }

    @Override
    @Transactional
    public LibroResponse eliminar(Long id) {
        var libroResponse= new LibroResponse();        
        var data = new ArrayList<Libro>();
        var infoList = new ArrayList<InfoRest>();
        var categoriaBuscada = this.libroRepository.findById(id);
        if(categoriaBuscada.isPresent()){
            this.libroRepository.deleteById(id);
        }else{
            infoList.add(new InfoRest(1,"Categoria no encontrada",1));
        }
        libroResponse.setData(data);
        libroResponse.setInfoList(infoList);
        return libroResponse; 
    }
    
}
