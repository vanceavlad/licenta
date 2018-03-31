package com.licenta.model.jsonbodymodel;


import java.time.LocalDateTime;

public class GetSchedulesBetweenDates {

    private LocalDateTime start;
    private LocalDateTime end;
    private String doctorKey;


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
