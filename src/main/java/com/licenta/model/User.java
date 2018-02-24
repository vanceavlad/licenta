package com.licenta.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private Integer active;

    @Column(name = "type")
    private String type;

    @Column(name = "uniqKeyGenerated")
    private String uniqKeyGenerated;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST},fetch = FetchType.EAGER ,mappedBy = "users")
    private Set<Doctor> doctors = new HashSet<>();


    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name="UserAllergy", joinColumns = {
            @JoinColumn(name="user_id", updatable = false)},
        inverseJoinColumns = {@JoinColumn(name="allergy_id",nullable = false, updatable =false)})

    private List<Allergy> allergies = new ArrayList<>();

    public User() {
    }


    public User(String name, String surname, String email, String password, Integer active) {
        this.name = name;
        this.lastName = surname;
        this.email = email;
        this.password = password;
        this.active = active;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUniqKeyGenerated() {
        return uniqKeyGenerated;
    }

    public void setUniqKeyGenerated(String uniqKeyGenerated) {
        this.uniqKeyGenerated = uniqKeyGenerated;
    }

    public List<Allergy> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<Allergy> allergies) {
        this.allergies = allergies;
    }

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }
}
