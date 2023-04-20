package com.example.dndprojectspring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "action")
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "action_id", nullable = false)
    private Long id;

    @Column(name = "description", nullable = true)
    private String description;

    @OneToOne
    @JoinColumn(name = "entry_id", referencedColumnName = "entry_id")
    private Entry entry;
}
