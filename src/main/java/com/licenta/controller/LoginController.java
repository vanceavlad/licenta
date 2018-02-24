package com.licenta.controller;


import com.licenta.dto.DoctorDTO;
import com.licenta.dto.UserDTO;
import com.licenta.dto.UserGenericDTO;
import com.licenta.facade.DoctorFacade;
import com.licenta.facade.UserFacade;
import com.licenta.model.User;
import com.licenta.validator.DoctorValidator;
import com.licenta.validator.UserValidator;
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
@RequestMapping("/login")
public class LoginController {

    public static final String DOCTOR = "DOCTOR";
    public static final String USER = "USER";

    @Autowired
    UserFacade userFacade;

    @Autowired
    DoctorFacade doctorFacade;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private DoctorValidator doctorValidator;


    @RequestMapping(value = "/loginForm", method = RequestMethod.GET)
    public String getLoginView(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("user") == null) {
            model.addAttribute("user", new UserDTO());
            return "login";
        } else {
            return "homepage";
        }
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String login(@ModelAttribute(name = "user") UserDTO userGenericDTO, BindingResult bindingResult,
                        Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String role = userGenericDTO.getRole();
        if (role == null) {
            bindingResult.rejectValue("email", "email.taken", "Please select role!");
        } else if (role.equals(DOCTOR)) {
            doctorValidator.validate(userGenericDTO, bindingResult);

        } else if (role.equals(USER)) {
            userValidator.validate(userGenericDTO, bindingResult);
        }

        //todo: insert al 3lea if in care verific daca exista role daca nu il pun sa seteze
        String page = "";
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("user", new UserDTO());
            model.addAttribute("userType", userGenericDTO.getRole());
            return "login";
        }

        if (USER.equals(role)) {
            UserDTO userForListing = userFacade.doLogin(userGenericDTO);
            session.setAttribute("currentUser", userForListing);
            model.addAttribute("currentUser", userForListing);
            page = userFacade.getPageForType(role);
        }


//        UserDTO userForListing = userFacade.doLogin(userGenericDTO);
//        if (userForListing.getEmail().equals(null)) {
//            model.addAttribute("errors", "User or password incorrect/ or desired type of login are not allowed");
//            page = "login";
//        } else {
//            session.setAttribute("currentUser", userForListing);
//            model.addAttribute("currentUser", userForListing);
//            page = userFacade.getPageForType(role);
//        }

        return page;
    }


    @RequestMapping(value = "/loginFormDoctor", method = RequestMethod.GET)
    public String getLoginViewForDoctor(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("doctor") == null) {
            model.addAttribute("doctor", new DoctorDTO());
            return "loginDoctor";
        } else {
            return "homepage";
        }
    }


    @RequestMapping(value = "/doLoginForDoctor", method = RequestMethod.POST)
    public String login(@ModelAttribute(name = "doctor") DoctorDTO doctorDTO, BindingResult bindingResult,
                        Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String role = doctorDTO.getRole();
        if (role == null) {
            bindingResult.rejectValue("email", "email.taken", "Please select role!");
        } else if (role.equals(DOCTOR)) {
            doctorValidator.validate(doctorDTO, bindingResult);
        }
        //todo: insert al 3lea if in care verific daca exista role daca nu il pun sa seteze
        String page = "";
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("doctor", new DoctorDTO());
            model.addAttribute("userType", doctorDTO.getRole());
            return "loginDoctor";
        }

        if (DOCTOR.equals(role)) {
            DoctorDTO doctorForListing = doctorFacade.doLogin(doctorDTO);
            session.setAttribute("currentDoctor", doctorForListing);
            model.addAttribute("currentDoctor", doctorForListing);
            page = userFacade.getPageForType(role);
        }

        return page;
    }

}
