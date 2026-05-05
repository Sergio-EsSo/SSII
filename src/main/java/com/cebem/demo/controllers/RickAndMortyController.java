package com.cebem.demo.controllers;

import java.util.ArrayList;
//import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;

import com.cebem.demo.models.PersonajeModel;
import com.cebem.demo.services.RickAndMortyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RickAndMortyController {
    private final RickAndMortyService servicio;

    @GetMapping("/personajes")
    public ArrayList<PersonajeModel> getPersonajes(){
        return servicio.obtenerPersonajesVivos();
    }
}
