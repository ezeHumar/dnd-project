package com.example.dndprojectspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "campaign")
public class Campaign {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "campaign_id", nullable = false)
    private Long id;

    @NotEmpty
    @Column(name = "title", nullable = false)
    private String title;

    @NotEmpty
    @Column(name = "description", nullable = true)
    private String description;

    @OneToOne()
    @JoinColumn(name = "dungeon_master_id", referencedColumnName = "dungeon_master_id")
    private DungeonMaster dungeonMaster;

    @Column(name = "is_private", nullable = false)
    private boolean isPrivate = true;

    @Column(name = "is_visible", nullable = false)
    private boolean isVisible = true;

    @ManyToMany(mappedBy = "campaigns")
    private List<User> users = new ArrayList<>();

    public Campaign() {
    }

    public Campaign(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void setAsPrivate(){
        this.isPrivate = true;
    }

    public void setAsPublic(){
        this.isPrivate = false;
    }

    public void setAsVisible(){
        this.isVisible = true;
    }

    public void setAsNotVisible(){
        isVisible = false;
    }

    public void addUser(User user){
        users.add(user);
    }
}