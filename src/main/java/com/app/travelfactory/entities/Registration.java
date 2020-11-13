package com.app.travelfactory.entities;

import com.app.travelfactory.entities.Campaign;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "registration")
public class Registration {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    @NotBlank(message = "Email is mandatory")
    @Pattern(regexp="^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$")
    private String email;

    @Column(name = "phone")
    @NotBlank(message = "Phone is mandatory")
    @Pattern(regexp="^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$")
    private String phone;


    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Campaign.class)
    @JoinColumn(name = "campaign_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Campaign campaign;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



}

