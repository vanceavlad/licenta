package com.licenta.controller;


import com.licenta.dto.UserGenericDTO;
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

    @RequestMapping(value = "/registerForm", method = RequestMethod.GET)
    public String getRegisterView(Model model) {
        model.addAttribute("userGenericDTO", new UserGenericDTO());
        model.addAttribute("role", new String());
        return "register";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createUser(@ModelAttribute(name = "userGenericDTO") UserGenericDTO userGenericDTO, BindingResult bindingResult,
                              Model model)
    {
        System.out.println("User " + userGenericDTO.getName());
        if(userGenericDTO.getRole().equals(DOCTOR)){
            //todo: save user as medic
        }
        else {
            userFacade.addUser(userGenericDTO);
        }
        return "login";
    }
}
