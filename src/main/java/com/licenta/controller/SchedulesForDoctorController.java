package com.licenta.controller;


import com.licenta.dto.ScheduleForDoctorDTO;
import com.licenta.facade.jsonbodyfacade.SchedulesForDoctorFacade;
import com.licenta.model.ScheduleForDoctor;
import com.licenta.model.jsonbodymodel.GetSchedules;
import com.licenta.model.jsonbodymodel.GetSchedulesBetweenDates;
import com.licenta.model.jsonbodymodel.UpdateSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/getSchedules")
public class SchedulesForDoctorController {


    @Autowired
    SchedulesForDoctorFacade schedulesForDoctorFacade;


    @RequestMapping(value = "/getSchedulesForDoctor", method = RequestMethod.POST)
    public @ResponseBody Iterable<GetSchedules>  getSearchUserProfiles(@RequestBody GetSchedulesBetweenDates search,
                                                                               HttpServletRequest request)
    {
        LocalDateTime start = search.getStart();
        LocalDateTime end = search.getEnd();
        String key = search.getDoctorKey();
        System.out.println(start);
        System.out.println(end);
        System.out.println(key);

        List<ScheduleForDoctorDTO> result = (List<ScheduleForDoctorDTO>)
                                                schedulesForDoctorFacade.getBetweenDates(start,end,key);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<GetSchedules> data = new ArrayList<>();

        for (ScheduleForDoctorDTO sc : result){
            GetSchedules schedule = new GetSchedules();
            schedule.setId(sc.getId().toString());
            schedule.setStart(sc.getStart().format(formatter));
            schedule.setEnd(sc.getEnd().format(formatter));
            schedule.setText(sc.getText());
            data.add(schedule);
        }

        return data;

        // your logic next
    }


    @RequestMapping(value = "/updateOnAction", method= RequestMethod.POST)
    public @ResponseBody String updateOnAction(@RequestBody UpdateSchedule update,
                                HttpServletRequest request)
    {

        Long id = update.getId();
        LocalDateTime start = update.getStart();
        LocalDateTime end = update.getEnd();
        String key = update.getDoctorKey();
        System.out.println(id);
        System.out.println(start);
        System.out.println(end);
        System.out.println(key);

        schedulesForDoctorFacade.updateScheduleOnACtion(id, start, end, key);

        return id.toString();


    }

    @RequestMapping(value="/mockSchedules", method = RequestMethod.GET)
    public String addSomeMockSchedule(){
        LocalDateTime date1Start = LocalDateTime.of(2018, 3, 15, 15, 30);
        LocalDateTime date1End = LocalDateTime.of(2018, 3, 15, 16, 30);
        LocalDateTime date2Start = LocalDateTime.of(2018, 2, 16, 17, 0);
        LocalDateTime date2End = LocalDateTime.of(2018, 2, 16, 18, 0);
        LocalDateTime date3Start = LocalDateTime.of(2018, 4, 17, 11, 0);
        LocalDateTime date3End = LocalDateTime.of(2018, 4, 17, 12, 30);

        String text1 = "test1";
        String text2 = "test2";
        String text3 = "test3";


        String key = "028f135b-c575-41f1-87fe-d7cbd7ea3860";

        schedulesForDoctorFacade.addNewSchedule(date1Start,date1End,text1,key);
        schedulesForDoctorFacade.addNewSchedule(date2Start,date2End,text2,key);
        schedulesForDoctorFacade.addNewSchedule(date3Start,date3End,text3,key);


        return "succesMockCreated";
    }

}
