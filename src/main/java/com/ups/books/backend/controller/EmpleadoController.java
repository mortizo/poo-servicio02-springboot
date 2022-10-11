/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ups.books.backend.controller;

import com.ups.books.backend.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author morti
 */
@Controller
@RequestMapping("/")
public class EmpleadoController {
    
    @Autowired
    private EmpleadoService empleadoService;
    
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("empleadoList",this.empleadoService.consultar());
        return "index";
    }
    
}
