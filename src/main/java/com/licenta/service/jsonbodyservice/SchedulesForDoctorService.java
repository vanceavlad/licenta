package com.licenta.service.jsonbodyservice;

import com.licenta.model.Doctor;
import com.licenta.model.ScheduleForDoctor;
import com.licenta.repository.DoctorDaoImpl;
import com.licenta.repository.jsonbodyrepository.SchedulesForDoctorDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SchedulesForDoctorService {


    @Autowired
    SchedulesForDoctorDaoImpl schedulesForDoctorDao;

    @Autowired
    DoctorDaoImpl doctorDao;


    public Iterable<ScheduleForDoctor> getBetweenDates(LocalDateTime start, LocalDateTime end, String key) {

        Doctor doctor = doctorDao.getDoctorByUniqueKey(key);

        List<ScheduleForDoctor> schedulesForDoctor = doctor.getSchedulesForDoctor();

        return schedulesForDoctor.stream()
                .filter(line -> (line.getStart().compareTo(start) > 0) && (line.getEnd().compareTo(end) < 0) )
                .collect(Collectors.toList());
    }

    public void addNewSchedule(LocalDateTime date1Start, LocalDateTime date1End, String text1, String key) {
        Doctor doctor = doctorDao.getDoctorByUniqueKey(key);

        ScheduleForDoctor scheduleForDoctor = new ScheduleForDoctor();
        scheduleForDoctor.setDoctor(doctor);
        scheduleForDoctor.setStart(date1Start);
        scheduleForDoctor.setEnd(date1End);
        scheduleForDoctor.setText(text1);

        doctorDao.saveOrUpdate(doctor);
        schedulesForDoctorDao.saveOrUpdate(scheduleForDoctor);
    }

    public void updateScheduleOnAction(Long id, LocalDateTime start, LocalDateTime end, String key) {
        Doctor doctor = doctorDao.getDoctorByUniqueKey(key);

        List<ScheduleForDoctor> schedulesForDoctor  = new ArrayList<>();
        schedulesForDoctor.addAll(doctor.getSchedulesForDoctor());

        for(ScheduleForDoctor sc : schedulesForDoctor){
            if(sc.getId().equals(id)){
                sc.setStart(start);
                sc.setEnd(end);
                doctorDao.saveOrUpdate(doctor);
                schedulesForDoctorDao.saveOrUpdate(sc);
            }
        }

    }
}
