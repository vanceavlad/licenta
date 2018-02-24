package com.licenta.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "doctorRequest")
public class DoctorRequest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "doctor_request_id")
    private Integer id;

    @Column(name = "user")
    private String user;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateTime")
    private Date date;

    @ManyToOne(optional = false)
    @JoinColumn(name = "doctor",referencedColumnName = "doctor_id")
    private Doctor doctor;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
