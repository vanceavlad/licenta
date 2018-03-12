package com.licenta.controller;


import com.licenta.dto.*;
import com.licenta.facade.DoctorFacade;
import com.licenta.facade.UserFacade;
import com.licenta.facade.ZoneFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    UserFacade userFacade;

    @Autowired
    DoctorFacade doctorFacade;

    @Autowired
    ZoneFacade zoneFacade;


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


    @RequestMapping(value="/viewUserByDoctor/{key}", method = RequestMethod.GET)
    public ModelAndView viewUserByDoctor(@PathVariable String key, HttpServletRequest request)
    {
        ModelAndView modelAndView = new ModelAndView("viewFilesFromDoctorView");
        Set<FileForUserDTO> filesForUser = doctorFacade.getFilesForUser(key);
        modelAndView.addObject("files", filesForUser);
        return modelAndView;
    }

    @RequestMapping(value="/viewFilesUserByDoctor/{code}", method = RequestMethod.GET)
    public ModelAndView viewUserByDoctor(@PathVariable String code)
    {
        ModelAndView modelAndView = new ModelAndView("viewFilesFromDoctorView");
        Set<FileForUserDTO> filesForUser = doctorFacade.findUserAssociatedWithFileCode(code);
        modelAndView.addObject("files", filesForUser);
        return modelAndView;
    }

    @RequestMapping(value = "/updateDoctorProfile/{uniqueKey}", method = RequestMethod.GET)
    public String updateDoctorProfile(@PathVariable String uniqueKey, Model model)
    {
        DoctorDTO doctorDTO = doctorFacade.findByKey(uniqueKey);
        List<String> zones = zoneFacade.getAllZone();
        model.addAttribute("doctor", doctorDTO);

        model.addAttribute("zones", zones);

        return "updateDoctorProfile";

    }

    @RequestMapping(value = "/updateDoctorProfile", method = RequestMethod.POST)
    public String updateProfile(@ModelAttribute("doctor") DoctorDTO doctorDTO)
    {
        System.out.println(doctorDTO);
        return null;

    }

}
