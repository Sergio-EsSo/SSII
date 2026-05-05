package com.cebem.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cebem.demo.entities.User;
import com.cebem.demo.repositories.UserRepository;

//import jakarta.validation.Valid;

@Service
public class UserService {
    //inyeccion de dependencias
    private final UserRepository repositorio;
    public UserService(UserRepository repo){
        this.repositorio = repo;
    }
    public List<User> getAllUsers(){
        //select * from users <- el ORM se encarga de esto (UserRepository)
        return repositorio.findAll();
    }
    public User guardar(User nuevoUsuario){
        return repositorio.save(nuevoUsuario);
    }
    public void borrarUsuario(Long id){
        repositorio.deleteById(id);
    }

    //TODO mejorar MUCHO este codigo
    public User modificarUsuario(Long id, User usuario){
        Optional<User> usuarioAModificar = repositorio.findById(id);
        if(usuarioAModificar.isPresent()){
            User usuarioOpcional = usuarioAModificar.get();
            //Lo cambio
            usuarioOpcional.setEmail(usuario.getEmail());
            usuarioOpcional.setName(usuario.getName());
            //Lo vuelvo a guardar
            return repositorio.save(usuarioOpcional);
        }
        else{ //No existe el usuario
            throw new RuntimeException("El usuario no existe");
        }
    }
}