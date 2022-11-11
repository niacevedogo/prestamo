package com.example.prestamos.services;


import com.example.prestamos.entities.User;
import com.example.prestamos.repository.IUserRepository;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.Optional;

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

    // encontrar por Id
    public User selectById(int Id){
        Optional<User> existe = this.userRepository.findById(Id);
        if(existe.isPresent()){
            return existe.get();
        }
        else {
            return null;
        }
    }

    // Eliminar un usuario
    public Response deleteUserById(int Id){
        Response response = new Response();
        try {
            this.userRepository.deleteById(Id);
            response.setCode(200);
            response.setMessage("Usuario eliminado exitosamente");
            return response;
        }
        catch (Exception ex){
            response.setCode(500);
            response.setMessage("Error" + ex.getMessage());
            return response;
        }
    }

    // update basico se hace por llave primaria
    public Response updateUser(User data){
        Response response = new Response();

        if(data.getId() == 0){
            response.setCode(500);
            response.setMessage("Error el Id del usuario no es valido");
            return response;
        }

        // Validar si el usuario a actualiar existe
        // podemos usar un método que ya existe
        User exists = selectById(data.getId());
        if (exists == null){
            response.setCode(500);
            response.setMessage("Error el usuario no existe");
            return response;
        }

        if (data.getCorreoElectronico().equals(null) || data.getCorreoElectronico().equals("")){
            response.setCode(500);
            response.setMessage("Error Correo no valido");
            return response;
        }

        if (!isValidEmailAddress(data.getCorreoElectronico())){
            response.setCode(500);
            response.setMessage("Error formato de correo no valido");
            return response;
        }

        exists.setCorreoElectronico(data.getCorreoElectronico());
        this.userRepository.save(exists);
        response.setCode(500);
        response.setMessage("Usuario actualizado correctamente");
        return response;
    }

    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

}
