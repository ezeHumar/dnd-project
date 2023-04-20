package com.example.dndprojectspring.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id", nullable = false)
    private Long id;

    @NotBlank(message = "There should be a text")
    @Column(name = "text", nullable = false)
    private String text;

    @NotNull(message = "There should be a Session")
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "session_id", referencedColumnName = "session_id")
    private Session session;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "dnd_character_id", referencedColumnName = "dnd_character_id")
    private DndCharacter dndCharacter;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "dungeon_master_id", referencedColumnName = "dungeon_master_id")
    private DungeonMaster dungeonMaster;

    public Note() {
    }
}
