package com.licenta.controller;


import com.licenta.dto.UserGenericDTO;
import com.licenta.model.User;
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


    @RequestMapping(value = "/loginForm", method = RequestMethod.GET)
    public String getRegisterView(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if(session.getAttribute("user") == null) {
            model.addAttribute("user", new UserGenericDTO());
            return "login";
        }
        else
        {
           return "homepage";
        }
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String createUser(@ModelAttribute(name = "userToLogin") UserGenericDTO userGenericDTO, BindingResult bindingResult,
                             Model model)
    {
        return null;
    }








}
