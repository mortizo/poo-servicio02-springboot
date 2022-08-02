/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ups.books.backend.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author UPS
 * https://www.youtube.com/watch?v=ckNz6ITf16E&ab_channel=JuanCabello%7CiTana
 * https://stackoverflow.com/questions/50486314/how-to-solve-403-error-in-spring-boot-post-request
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /*
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean("authenticationManager")
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
     */
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("mortizo").password("{noop}"+"mortizo").roles("ADMIN")
                .and()
                .withUser("wimper").password("{noop}"+"wimper").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http/*
                .cors().and().csrf().disable()
                .httpBasic(withDefaults())
                .authorizeRequests()
                .antMatchers("/v1/libros/**").permitAll()
                .antMatchers("/v1/categorias/**").hasRole("ADMIN")
                .anyRequest().authenticated();
            */  
            .cors().and().csrf().disable()
                .httpBasic(withDefaults())
                .authorizeRequests()
                .antMatchers("/v1/libros/**").permitAll()
                .antMatchers("/v1/categorias/**").permitAll();
                
    }
    
}