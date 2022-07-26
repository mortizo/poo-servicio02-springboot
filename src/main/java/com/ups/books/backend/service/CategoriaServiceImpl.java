/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ups.books.backend.service;

import com.ups.books.backend.controller.response.CategoriaResponse;
import com.ups.books.backend.controller.response.InfoRest;
import com.ups.books.backend.model.Categoria;
import com.ups.books.backend.model.repository.CategoriaRepository;
import java.util.ArrayList;
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
        var data = (List<Categoria>) this.categoriaRepository.findAll();
        var infoList = new ArrayList<InfoRest>();
        categoriaResponse.setData(data);
        categoriaResponse.setInfoList(infoList);
        return categoriaResponse;
    }
    
    @Override
    @Transactional(readOnly = true)
    public CategoriaResponse buscarPorId(Long id) {
        var categoriaResponse= new CategoriaResponse();        
        var data = new ArrayList<Categoria>();
        var infoList = new ArrayList<InfoRest>();
        var categoriaBuscada = this.categoriaRepository.findById(id);
        if(categoriaBuscada.isPresent()){
            data.add(categoriaBuscada.get());
        }else{
            infoList.add(new InfoRest(1,"Categoria no encontrada",1));
        }
        categoriaResponse.setData(data);
        categoriaResponse.setInfoList(infoList);
        return categoriaResponse;
    }

    @Override
    @Transactional
    public CategoriaResponse crear(Categoria categoria) {
        var categoriaResponse= new CategoriaResponse(); 
        var data = new ArrayList<Categoria>();
        var infoList = new ArrayList<InfoRest>();
        data.add(this.categoriaRepository.save(categoria));
        categoriaResponse.setData(data);
        categoriaResponse.setInfoList(infoList);
        return categoriaResponse;
    }

    @Override
    @Transactional
    public CategoriaResponse modificar(Categoria categoria, Long id) {
        var categoriaResponse= new CategoriaResponse();        
        var data = new ArrayList<Categoria>();
        var infoList = new ArrayList<InfoRest>();
        var categoriaBuscada = this.categoriaRepository.findById(id);
        if(categoriaBuscada.isPresent()){
            categoriaBuscada.get().setNombre(categoria.getNombre());
            categoriaBuscada.get().setDescripcion(categoria.getDescripcion());
            data.add(this.categoriaRepository.save(categoriaBuscada.get()));
        }else{
            infoList.add(new InfoRest(1,"Categoria no encontrada",1));
        }
        categoriaResponse.setData(data);
        categoriaResponse.setInfoList(infoList);
        return categoriaResponse;  
    }

    @Override
    @Transactional
    public CategoriaResponse eliminar(Long id) {
        var categoriaResponse= new CategoriaResponse();        
        var data = new ArrayList<Categoria>();
        var infoList = new ArrayList<InfoRest>();
        var categoriaBuscada = this.categoriaRepository.findById(id);
        if(categoriaBuscada.isPresent()){
            this.categoriaRepository.deleteById(id);
        }else{
            infoList.add(new InfoRest(1,"Categoria no encontrada",1));
        }
        categoriaResponse.setData(data);
        categoriaResponse.setInfoList(infoList);
        return categoriaResponse;  
    }
    
}
