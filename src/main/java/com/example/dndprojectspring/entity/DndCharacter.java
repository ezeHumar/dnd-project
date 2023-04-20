package com.example.dndprojectspring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "dnd_character")
public class DndCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dnd_character_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "npc", nullable = false)
    private boolean npc;

    @Column(name = "description", nullable = true)
    private String description;

//These properties will be commented since they are not necessary for now
//    @Column(name = "character_class", nullable = true)
//    private String characterClass;
//
//    @Column(name = "level", nullable = true)
//    private byte level;
//
//    @Column(name = "experience_points", nullable = true)
//    private byte experiencePoints;
//
//    @Column(name = "background", nullable = true)
//    private String background;
//
//    @Column(name = "alignment", nullable = true)
//    private String alignment;
//
//    @Column(name = "race", nullable = true)
//    private String race;
//
//    @Column(name = "armor_class", nullable = true)
//    private byte armorClass;
//
//    @Column(name = "initiative", nullable = true)
//    private byte initiative;
//
//    @Column(name = "speed", nullable = true)
//    private byte speed;
//
//    @Column(name = "maximum_hit_points", nullable = true)
//    private byte maximumHitPoints;
//
//    @Column(name = "current_hit_points", nullable = true)
//    private byte currentHitPoints;
//
//    @Column(name = "hit_dice", nullable = true)
//    private byte hitDice;
//
//    @Column(name = "hit_dice_modifier", nullable = true)
//    private byte hitDiceModifier;
//
//    @Column(name = "hit_dice_amount", nullable = true)
//    private byte hitDiceAmount;
//
//    @Column(name = "gold", nullable = true)
//    private Integer gold;
//
//    @Column(name = "platinum", nullable = true)
//    private Integer platinum;
//
//    @Column(name = "electrum", nullable = true)
//    private Integer electrum;
//
//    @Column(name = "silver", nullable = true)
//    private Integer silver;
//
//    @Column(name = "cooper", nullable = true)
//    private Integer cooper;
//
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "app_user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "campaign_id", referencedColumnName = "campaign_id")
    private Campaign campaign;

    public DndCharacter() {
    }

    public DndCharacter(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "DndCharacter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
