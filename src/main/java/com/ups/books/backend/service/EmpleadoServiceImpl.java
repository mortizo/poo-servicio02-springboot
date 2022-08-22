/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ups.books.backend.service;

import com.ups.books.backend.controller.response.EmpleadoResponse;
import com.ups.books.backend.controller.response.InfoRest;
import com.ups.books.backend.model.Empleado;
import com.ups.books.backend.model.repository.EmpleadoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author morti
 */
@Service
public class EmpleadoServiceImpl implements EmpleadoService{
    
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public EmpleadoResponse consultar() {
                var empleadoResponse= new EmpleadoResponse();        
        var data = (List<Empleado>) this.empleadoRepository.findAll();
        var infoList = new ArrayList<InfoRest>();
        empleadoResponse.setData(data);
        empleadoResponse.setInfoList(infoList);
        return empleadoResponse;  
    }

    @Override
    public EmpleadoResponse buscarPorId(Long id) {
        var empleadoResponse= new EmpleadoResponse();        
        var data = new ArrayList<Empleado>();
        var infoList = new ArrayList<InfoRest>();
        var empleadoBuscado = this.empleadoRepository.findById(id);
        if(empleadoBuscado.isPresent()){
            data.add(empleadoBuscado.get());
        }else{
            infoList.add(new InfoRest(1,"Categoria no encontrada",1));
        }
        empleadoResponse.setData(data);
        empleadoResponse.setInfoList(infoList);
        return empleadoResponse;  }

    @Override
    public EmpleadoResponse crear(Empleado empleado) {
        var empleadoResponse= new EmpleadoResponse(); 
        var data = new ArrayList<Empleado>();
        var infoList = new ArrayList<InfoRest>();
        data.add(this.empleadoRepository.save(empleado));
        empleadoResponse.setData(data);
        empleadoResponse.setInfoList(infoList);
        return empleadoResponse;      }


    @Override
    public EmpleadoResponse eliminar(Long id) {
        var empleadoResponse= new EmpleadoResponse();        
        var data = new ArrayList<Empleado>();
        var infoList = new ArrayList<InfoRest>();
        var categoriaBuscada = this.empleadoRepository.findById(id);
        if(categoriaBuscada.isPresent()){
            this.empleadoRepository.deleteById(id);
        }else{
            infoList.add(new InfoRest(1,"Categoria no encontrada",1));
        }
        empleadoResponse.setData(data);
        empleadoResponse.setInfoList(infoList);
        return empleadoResponse; 
    }
    
}
