package com.example.prestamos.controllers;


import com.example.prestamos.entities.User;
import com.example.prestamos.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class IndexController {
    // Se coloca una propiedad del tipo UserService, para poder trabajar con la logica de negocio de la aplicacion
    private UserService userService;

    //por medio de la inyeccion de dependencias, se inicializa el servicio

    public IndexController(UserService service){
        this.userService = service;
    }


    @RequestMapping("/")   // ("/") significa punto de entrada
    //crear metodo de inicio
    public String index(){
        return "Hola developers";
    }

    @RequestMapping("getusuarios")
    public ArrayList<User> getUsuarios(){
        return this.userService.selectAll();
    }




}
