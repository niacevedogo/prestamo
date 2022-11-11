package com.example.prestamos.services;


import com.example.prestamos.entities.User;
import com.example.prestamos.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    private IUserRepository userRepository;

    public UserService(IUserRepository rep){
        this.userRepository = rep;
    }

    public ArrayList<User> selectAll(){
        return (ArrayList<User>) this.userRepository.findAll();
        // hace un Select * from y retorna de la base in listados de los usuarios
    }

    public Response createUser(User data){
        // se instancia la clase
        Response response = new Response();
        this.userRepository.save(data);
        response.setCode(200);
        response.setMessage("Usuario registrado exitosamente");
        return  response;
        // el controlador usa este método
    }



}
