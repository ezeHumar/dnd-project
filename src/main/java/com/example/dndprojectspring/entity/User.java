package com.example.dndprojectspring.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_user_id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "active", nullable = false)
    private boolean active;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "campaign_app_user",
            joinColumns = @JoinColumn(name = "users_app_user_id"),
            inverseJoinColumns = @JoinColumn(name = "campaign_campaign_id"))
    private List<Campaign> campaigns;

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public User(String username, String email, String password, boolean active) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.active = active;
    }

    private User(UserBuilder builder){
        this.id = builder.id;
        this.username = builder.username;
        this.email = builder.email;
        this.password = builder.password;
        this.active = builder.active;
    }

    public void addCampaign(Campaign campaign){
        this.campaigns.add(campaign);
    }

    public static class UserBuilder{

        private Long id;
        private String username;
        private String email;
        private String password;
        private boolean active;

        public UserBuilder(String username, String email, String password, boolean active) {
            this.username = username;
            this.email = email;
            this.password = password;
            this.active = active;
        }

        public UserBuilder setId(Long id){
            this.id = id;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}