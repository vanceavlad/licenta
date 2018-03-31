package com.licenta.dto;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public class ScheduleForDoctorDTO {

    private Long id;
    private String text;
    private LocalDateTime start;
    private LocalDateTime end;
    private String doctorKey;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getDoctorKey() {
        return doctorKey;
    }

    public void setDoctorKey(String doctorKey) {
        this.doctorKey = doctorKey;
    }
}
