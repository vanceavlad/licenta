package com.licenta.controller;


import com.licenta.dto.DoctorDTO;
import com.licenta.dto.UserDTO;
import com.licenta.dto.UserGenericDTO;
import com.licenta.facade.DoctorFacade;
import com.licenta.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    UserFacade userFacade;

    @Autowired
    DoctorFacade doctorFacade;


    @RequestMapping(value = "/myProfile", method = RequestMethod.GET)
    public String myProfile(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        DoctorDTO doctorGenericDTO = (DoctorDTO) session.getAttribute("currentDoctor");
        model.addAttribute("doctorRequests", doctorGenericDTO.getDoctorRequests());
        model.addAttribute("currentDoctor", doctorGenericDTO);
        model.addAttribute("searchedUser", new UserDTO());
        return "doctorProfile";
    }


    @RequestMapping(value = "/searchUser", method = RequestMethod.POST)
    public String search(@ModelAttribute("searchedUser") UserDTO searchedUser, Model model,
                         BindingResult bindingResult, HttpServletRequest request) {

        HttpSession session = request.getSession();

        DoctorDTO doctor = (DoctorDTO) session.getAttribute("currentDoctor");


        String goToPage = "";
        UserDTO userForListing = userFacade.getUserByUniqueKey(searchedUser.getUniqKey());

        boolean hasUser = doctorFacade.verifyIfDoctorHasUser(doctor, userForListing);


        if (userForListing != null) {
            model.addAttribute("resultUser", userForListing);
            model.addAttribute("existedAllergies", userForListing.getAllergies());
            model.addAttribute("hasUser", hasUser);
//            model.addAttribute("resultUser", userForListing);
//            return "searchedUserDetails";
            goToPage = "searchedUserDetails";
        } else {
            bindingResult.rejectValue("uniqueKey", "uniqueKey.empty", "User with unique id entered is not exists!");
            goToPage = "doctorProfile";
        }
        return goToPage;
    }


    @RequestMapping(value = "/addDoctorToUser", method = RequestMethod.POST)
    public String addDoctorToUser(@ModelAttribute(name = "resultUser") UserDTO userGeneric,
                                  BindingResult bindingResult, Model model, HttpServletRequest request) {
        String goToPage;
        HttpSession session = request.getSession();

        DoctorDTO doctorDTO = (DoctorDTO) session.getAttribute("currentDoctor");

        doctorDTO.setDoctorRequests(doctorFacade.connectUserWithDoctor(doctorDTO, userGeneric));
        model.addAttribute("currentDoctor", doctorDTO);
        return "redirect:/doctor/myProfile";
    }
}
