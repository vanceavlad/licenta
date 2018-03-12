package com.licenta.dto;

import com.licenta.model.Allergy;
import com.licenta.model.DoctorRequest;
import com.licenta.model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DoctorDTO {


    private String name;
    private String lastName;
    private String password;
    private String email;
    private String role;
    private String uniqKey;
    private Set<User> users = new HashSet<>();
    private List<DoctorRequest> doctorRequests = new ArrayList<>();
    private AddressDTO addressDTO;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUniqKey() {
        return uniqKey;
    }

    public void setUniqKey(String uniqKey) {
        this.uniqKey = uniqKey;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public List<DoctorRequest> getDoctorRequests() {
        return doctorRequests;
    }

    public void setDoctorRequests(List<DoctorRequest> doctorRequests) {
        this.doctorRequests = doctorRequests;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }
}

