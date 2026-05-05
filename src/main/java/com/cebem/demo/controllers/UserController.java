package com.cebem.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cebem.demo.entities.User;
import com.cebem.demo.services.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    //Inyeccion de dependencias
    private final UserService servicio;
    //no hace falta inyectar si uso lombok
    /*public UserController(UserService servicio){
        this.servicio = servicio;
    }*/
    //http://localhost:8080/users
    @GetMapping
    List<User> obtenerTodosLosUsuarios(){
        //buscar todos los usuarios guardados en la BD
        //select * from users
        //ORM (JPA -> Hibernate)
        //Devolverlos
        return servicio.getAllUsers(); //me da error despues de inicializar un repositorio git aqui
    }

    //TODO validaciones
    @PostMapping
    User crearUsuario(@RequestBody @Valid User nuevoUsuario){
        return servicio.guardar(nuevoUsuario);
    }

    @DeleteMapping("/{id}")
    void borrarUsuario(@PathVariable Long id){
        servicio.borrarUsuario(id);
    }

    @PutMapping("/{id}")
    User modificarUsuario(@PathVariable Long id, @RequestBody @Valid User usuario){
        return servicio.modificarUsuario(id, usuario);
    }
    
}