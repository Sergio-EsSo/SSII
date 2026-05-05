package com.cebem.demo.repositories;

import com.cebem.demo.models.CharacterModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<CharacterModel, Long> {

}