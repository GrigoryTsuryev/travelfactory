package com.app.travelfactory.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "campaign")
public class Campaign {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Name is mandatory")
    private String name;


    @JsonIgnore
    @OneToMany(mappedBy="campaign", fetch = FetchType.LAZY)
    private Set<Registration> registrations;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<Registration> registrations) {
        this.registrations = registrations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
