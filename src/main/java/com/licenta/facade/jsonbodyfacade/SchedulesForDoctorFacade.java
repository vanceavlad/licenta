package com.licenta.facade.jsonbodyfacade;

import com.licenta.dto.ScheduleForDoctorDTO;
import com.licenta.facade.populator.ScheduleForDoctorPopulator;
import com.licenta.model.ScheduleForDoctor;
import com.licenta.service.jsonbodyservice.SchedulesForDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SchedulesForDoctorFacade {

    @Autowired
    SchedulesForDoctorService schedulesForDoctorService;

    @Autowired
    ScheduleForDoctorPopulator scheduleForDoctorPopulator;


    public Iterable<ScheduleForDoctorDTO> getBetweenDates(LocalDateTime start, LocalDateTime end, String key) {
        Iterable<ScheduleForDoctor> scheduleList = schedulesForDoctorService.getBetweenDates(start,end,key);
        return scheduleForDoctorPopulator.scheduleForDoctorFromModelToDTOS(scheduleList);


    }

    public void addNewSchedule(LocalDateTime date1Start, LocalDateTime date1End, String text1, String key) {
         schedulesForDoctorService.addNewSchedule(date1Start,date1End,text1,key);
    }

    public void updateScheduleOnACtion(Long id, LocalDateTime start, LocalDateTime end, String key) {
        schedulesForDoctorService.updateScheduleOnAction(id,start,end,key);
    }
}
