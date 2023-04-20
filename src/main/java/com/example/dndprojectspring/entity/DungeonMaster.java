package com.example.dndprojectspring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "dungeon_master")
public class DungeonMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dungeon_master_id", nullable = false)
    private Long id;

    @Column(name = "description", nullable = true)
    private String description;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "app_user_id")
    private User user;

    public DungeonMaster() {
    }

}
