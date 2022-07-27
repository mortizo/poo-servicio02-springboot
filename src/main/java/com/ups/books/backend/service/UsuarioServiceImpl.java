/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ups.books.backend.service;

import com.ups.books.backend.model.Usuario;
import com.ups.books.backend.model.repository.UsuarioRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author morti
 */
@Service
public class UsuarioServiceImpl implements UserDetailsService {

    private static final Logger log= LoggerFactory.getLogger(UsuarioServiceImpl.class);
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = this.usuarioRepository.findByNombre(username);
        if(usuario==null){
            log.error("Error, el usuario no existe");
            throw new UsernameNotFoundException("Error, el usuario no existe");
        }
        List<GrantedAuthority> authorities = usuario.getRolList().
                stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getNombreRole()))
                .peek(autoridad -> log.info("Role: "+autoridad.getAuthority()))
                .collect(Collectors.toList());
        return new User(usuario.getNombre(), usuario.getPassword(), 
                usuario.getHabilitado(),true,true,true,authorities);
    }

}
