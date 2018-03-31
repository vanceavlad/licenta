package com.licenta.facade.populator;

import com.licenta.dto.ScheduleForDoctorDTO;
import com.licenta.model.ScheduleForDoctor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ScheduleForDoctorPopulator {

    private ScheduleForDoctorDTO scheduleForDoctorFromModelToDTO(ScheduleForDoctor scheduleForDoctorModel)
    {
        ScheduleForDoctorDTO scheduleForDoctorDTO = new ScheduleForDoctorDTO();

        if(scheduleForDoctorModel != null){
            scheduleForDoctorDTO.setId(scheduleForDoctorModel.getId());
            scheduleForDoctorDTO.setText(scheduleForDoctorModel.getText());
            scheduleForDoctorDTO.setStart(scheduleForDoctorModel.getStart());
            scheduleForDoctorDTO.setEnd(scheduleForDoctorModel.getEnd());
            scheduleForDoctorDTO.setDoctorKey(scheduleForDoctorModel.getDoctor().getUniqKeyGenerated());
        }
        return scheduleForDoctorDTO;
    }

    public Iterable<ScheduleForDoctorDTO>  scheduleForDoctorFromModelToDTOS(Iterable<ScheduleForDoctor> schedulesForDoctorModel)
    {
        List<ScheduleForDoctorDTO> scheduleForDoctorDTOS = new ArrayList<>();
        if(schedulesForDoctorModel!=null){
            for(ScheduleForDoctor scheduleForDoctor: schedulesForDoctorModel){
                scheduleForDoctorDTOS.add(scheduleForDoctorFromModelToDTO(scheduleForDoctor));
            }
        }
        return scheduleForDoctorDTOS;
    }
}
