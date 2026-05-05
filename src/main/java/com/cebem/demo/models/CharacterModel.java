package com.cebem.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="characters") //de RPG/TTRPG, por ejemplo
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CharacterModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //esto deberia ser del entity y no del model, pero no entiendo la diferencai

    public String name;
    public int HP; //
    public int ATK;
    public int DEF;
    public int SPD;
}
