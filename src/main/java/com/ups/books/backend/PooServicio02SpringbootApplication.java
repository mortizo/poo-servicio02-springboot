package com.ups.books.backend;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PooServicio02SpringbootApplication //implements CommandLineRunner 
{
/*
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
        
    @Override
    public void run(String... args) throws Exception {
        String password = "123456";

        for (int i = 0; i < 20; i++) {
            String passwordBcrypt = this.passwordEncoder.encode(password);
            System.out.println(passwordBcrypt);
        }
    }
*/
   // public static void main(String[] args) {
     //   SpringApplication.run(PooServicio02SpringbootApplication.class, args);
   // }

    public static void main(String[] args) {
        System.out.println("Hola Mundo");
        //calcular el factorial de un numero
        int numero = 10;

        int factorial = 1;
        for (int i = 1; i <= numero; i++) {
            factorial = factorial * i;
        }
        System.out.println("El factorial de " + numero + " es: " + factorial);

    }

}
