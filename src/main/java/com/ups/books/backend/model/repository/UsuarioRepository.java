/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ups.books.backend.model.repository;

import com.ups.books.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author morti
 */
public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{
    
    public Usuario findByNombre(String nombreUsuario);
    @Query("select u from Usuario u where u.nombre=?1")
    public Usuario findByIdNombreV2(String nombreUsuario);
    
    
}
