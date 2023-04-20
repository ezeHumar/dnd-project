package com.example.dndprojectspring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "entry")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entry_id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = true)
    private String title;

    @Column(name = "description", nullable = true)
    private String description;

    @OneToOne
    @JoinColumn(name = "dnd_character_id", referencedColumnName = "dnd_character_id")
    private DndCharacter dndCharacter;

    @OneToOne
    @JoinColumn(name = "dungeon_master_id", referencedColumnName = "dungeon_master_id")
    private DungeonMaster dungeonMaster;

    @OneToOne
    @JoinColumn(name = "session_id", referencedColumnName = "session_id")
    private Session session;

    public Entry() {
    }
}
