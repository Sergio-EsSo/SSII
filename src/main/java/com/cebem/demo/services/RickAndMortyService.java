package com.cebem.demo.services;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cebem.demo.models.PersonajeModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RickAndMortyService {
    private final RestTemplate restTemplate; //Inyeccion de dependencias

    @Value("${rickandmorty.url}")
    private String RICKANDMORTY_URL;

    public ArrayList<PersonajeModel> obtenerPersonajesVivos(){
        String url = RICKANDMORTY_URL+"?status=alive";
        Map<String, Object> respuesta = restTemplate.getForObject(url, Map.class);
        return (ArrayList<PersonajeModel>) respuesta.get("results");
    }
}