/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ups.books.backend.service;

import com.ups.books.backend.controller.response.EmpleadoResponse;
import com.ups.books.backend.model.Empleado;

/**
 *
 * @author morti
 */
public interface EmpleadoService {

    public EmpleadoResponse consultar();

    public EmpleadoResponse buscarPorId(Long id);

    public EmpleadoResponse crear(Empleado empleado);

    public EmpleadoResponse eliminar(Long id);

}
