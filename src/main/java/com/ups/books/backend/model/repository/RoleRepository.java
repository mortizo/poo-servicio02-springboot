/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ups.books.backend.model.repository;

import com.ups.books.backend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author morti
 */
public interface RoleRepository  extends JpaRepository<Role, Long>{
    
}
