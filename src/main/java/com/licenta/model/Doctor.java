package com.licenta.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "doctor")
public class Doctor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "doctor_id")
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

    @OneToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE,CascadeType.PERSIST}, mappedBy = "doctor")
    private Address address;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.PERSIST}, mappedBy = "doctor")
    private List<DoctorRequest> doctorRequests = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(
            name = "Doctor_User",
            joinColumns = { @JoinColumn(name = "doctor_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    private Set<User> users = new HashSet<>();


    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST},mappedBy = "doctor")
    private List<ScheduleForDoctor> schedulesForDoctor;


    public Doctor() {
    }


    public Doctor(String name, String surname, String email, String password, Integer active) {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<DoctorRequest> getDoctorRequests() {
        return doctorRequests;
    }

    public void setDoctorRequests(List<DoctorRequest> doctorRequests) {
        this.doctorRequests = doctorRequests;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public List<ScheduleForDoctor> getSchedulesForDoctor() {
        return schedulesForDoctor;
    }

    public void setSchedulesForDoctor(List<ScheduleForDoctor> schedulesForDoctor) {
        this.schedulesForDoctor = schedulesForDoctor;
    }
}

