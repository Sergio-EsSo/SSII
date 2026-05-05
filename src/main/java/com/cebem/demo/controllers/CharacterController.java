package com.cebem.demo.controllers;

import com.cebem.demo.models.CharacterModel;
import com.cebem.demo.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterService service;

    @GetMapping
    public List<CharacterModel> getAll() {
        return service.listAllCharacters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterModel> obtenerPorId(@PathVariable Long id) {
        return service.findCharacterById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CharacterModel crear(@RequestBody CharacterModel charac) {
        return service.saveCharacter(charac);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterModel> actualizar(@PathVariable Long id, @RequestBody CharacterModel charac) {
        try {
            return ResponseEntity.ok(service.actualizar(id, charac));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            service.deleteCharacter(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}