package com.cebem.demo.controllers;

//import java.lang.annotation.Repeatable;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cebem.demo.models.LuzModel;

// Se encarga:
// recibir peticiones
// llamar al servicio correspondiente
// devolver una respuesta

@RestController
public class HelloController {

    // http://localhost:8080/
    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }

    // http://localhost:8080/encender
    @GetMapping("/encender")
    public String encender() {
        //int a = 3+5;
        return "Luz encendida";
    }

    @GetMapping("/apagar")
    public String apagar(@PathVariable Long numLuz){
        return "luz apagada: "+numLuz;
    }

    @GetMapping("/estado")
    public String verEstado(
        @RequestParam String lugar,
        @RequestParam String nombre){
            return "Vamos a ver el estado de la luz en "+lugar+" con nombre "+nombre;
    }

    @PostMapping("/crear_luz")
    public String crearLuzNueva(@RequestBody LuzModel nuevaLuz){
        return "Luz nueva creada "+nuevaLuz.nombre+" "+nuevaLuz.localizacion; //no funciona del todo, preguntar despues
    }

    //Borrar luz!!
    //DELETE http://localhost:8080/borrar_luz
    @DeleteMapping("/borrar_luz/{id}")
    public String borrarLuz(@PathVariable long id){
        return "Luz borrada correctamente "+id; 
    }

    @PutMapping("/cambiar_luz/{id}")
    public String cambiarLuz(@PathVariable long id, @RequestBody LuzModel luz){
        return "La luz se cambio correctamente: "+id+" con el nombre "+luz.nombre;
    }

    //Hacer un endpoint al que le pases un numero (como parametro) y te diga si es par o impar
    //GET http://localhost:8080/es_par/XXX --> si XXX es par o impar
    @GetMapping("/par/(numero)")
    public String par(@PathVariable int numero){
        return numero%2==0 ? "El número es par" : "El número es impar";
    }

    //hacer un endpoint al que le pases 2 numeros (como query params) y los multiplique
    //GET http://localhost:8080/sumar?num1=xxx&num2=yyy      -->    xxx * yyy
    @GetMapping("/multiplicar")
    public String multiplicar(@RequestParam float num1, @RequestParam float num2){
        return num1*num2+"";
    }

    // Hacer un endpoint que dado un usuario borre un post del mismo
    // DELETE http://localhost:8080/usuario/XXX/post/YYY    --> Borra el post YYY del usuario XXX
    @DeleteMapping("/usuario/{usuarioId}/post/{postId}")
    public String borrarPostDeUsusario(
        @PathVariable String ususarioId,
        @PathVariable String postId
    ){
        return "Se ha borrado el post %s del ususario %s".formatted(postId, ususarioId);         
    }
}