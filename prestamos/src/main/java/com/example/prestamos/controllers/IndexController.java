package com.example.prestamos.controllers;


import com.example.prestamos.entities.TipoDocumento;
import com.example.prestamos.entities.User;
import com.example.prestamos.services.Response;
import com.example.prestamos.services.TipoDocumentoService;
import com.example.prestamos.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping ("index")
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



    // el metodo post nunca retona nada salvo que se use un postman

    @PostMapping("create")  //@RequestBody lo que se recibe esta en formato JSON
    public Response createUser(@RequestBody User request){
        // especificar que información recibe para guardarla
        return this.userService.createUser(request);

    }


    // {id} con el @PathVariable pone la ruta con el valor que se quiera introducir
    @RequestMapping("getuser/{id}")
    public User getusuraio(@PathVariable int id){
        return this.userService.selectById(id);
    }

    @DeleteMapping("delete/{id}")
    public Response deleteUsuario(@PathVariable int id){
        return this.userService.deleteUserById(id);
    }


    @PutMapping("update")
    public Response updateUser (@RequestBody User request){
        return this.userService.updateUser(request);
    }


//estos son servicios REST-FULL el formato de transmisión de datos esta en JSON

    // las credenciales de acceso siempre se envia por POST
    @PostMapping("auth")
    public Response auth(@RequestBody User request){
        return this.userService.loginUnser(request);
    }


}
