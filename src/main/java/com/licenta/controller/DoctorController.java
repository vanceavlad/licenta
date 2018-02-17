package com.licenta.controller;


import com.licenta.dto.UserGenericDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/doctor")
public class DoctorController {


    @RequestMapping(value = "/myProfile", method = RequestMethod.GET)
    public String myProfile(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        UserGenericDTO userGenericDTO = (UserGenericDTO) session.getAttribute("currentUser");
        model.addAttribute("currentUser", userGenericDTO);
        return "doctorProfile";
    }
}
