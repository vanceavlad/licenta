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
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/register")
public class RegisterController {


    public static final String DOCTOR = "DOCTOR";
    public static final String USER = "USER";

    @Autowired
    UserFacade userFacade;

    @Autowired
    DoctorFacade doctorFacade;

    @RequestMapping(value = "/registerForm", method = RequestMethod.GET)
    public String getRegisterView(Model model) {
        model.addAttribute("userGenericDTO", new UserDTO());
        model.addAttribute("role", new String());
        return "register";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createUser(@ModelAttribute(name = "userGenericDTO") UserDTO userGenericDTO, BindingResult bindingResult,
                             Model model) {
        model.addAttribute("userType", userGenericDTO.getRole());
        model.addAttribute("user", new UserDTO());
        System.out.println("User " + userGenericDTO.getName());
//        if(userGenericDTO.getRole().equals(DOCTOR)){
//            userFacade.addDoctor(userGenericDTO);
//        }
        if (userGenericDTO.getRole().equals(USER)) {
            userFacade.addUser(userGenericDTO);
        }
        return "login";
    }

    @RequestMapping(value = "/registerFormDoctor", method = RequestMethod.GET)
    public String getRegisterViewForDoctor(Model model) {

        model.addAttribute("userGenericDTO", new DoctorDTO());
        model.addAttribute("role", new String());
        return "registerDoctor";
    }

    @RequestMapping(value = "/createDoctor", method = RequestMethod.POST)
    public String createUser(@ModelAttribute(name = "doctorGenericDTO") DoctorDTO doctorGenericDTO, BindingResult bindingResult,
                             Model model) {
        model.addAttribute("userType", doctorGenericDTO.getRole());
        model.addAttribute("doctor", new DoctorDTO());
        System.out.println("User " + doctorGenericDTO.getName());
//        if(userGenericDTO.getRole().equals(DOCTOR)){
//            userFacade.addDoctor(userGenericDTO);
//        }
        if (doctorGenericDTO.getRole().equals(USER)) {
            doctorFacade.addDoctor(doctorGenericDTO);
        }
        return "loginDoctor";
    }

}
