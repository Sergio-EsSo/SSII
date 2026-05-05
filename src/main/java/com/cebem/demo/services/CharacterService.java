package com.cebem.demo.services;

import com.cebem.demo.models.CharacterModel;
import com.cebem.demo.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository repository;

    public List<CharacterModel> listAllCharacters() {
        return repository.findAll();
    }
    public Optional<CharacterModel> findCharacterById(Long id) {
        return repository.findById(id);
    }
    public CharacterModel saveCharacter(CharacterModel crc) {
        return repository.save(crc);
    }

    public CharacterModel actualizar(Long id, CharacterModel crc) {
        return repository.findById(id).map(character -> {
            character.setName(crc.getName());
            character.setATK(crc.getATK());
            character.setDEF(crc.getDEF());
            character.setHP(crc.getHP());
            character.setSPD(crc.getSPD());
            return repository.save(character);
        }).orElseThrow(() -> new RuntimeException("Character with it ID ("+id+") not found."));
    }

    public void deleteCharacter(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("ID ("+id+") not found. Cannot delete.");
        }
        repository.deleteById(id);
    }
}