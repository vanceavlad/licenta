package com.licenta.controller;


import com.licenta.dto.UserGenericDTO;
import com.licenta.facade.UserFacade;
import com.licenta.model.User;
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


    @Autowired
    UserFacade userFacade;

    @Autowired
    private UserValidator userValidator;


    @RequestMapping(value = "/loginForm", method = RequestMethod.GET)
    public String getRegisterView(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("user") == null) {
            model.addAttribute("user", new UserGenericDTO());
            return "login";
        } else {
            return "homepage";
        }
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String createUser(@ModelAttribute(name = "user") UserGenericDTO userGenericDTO, BindingResult bindingResult,
                             Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();

        userValidator.validate(userGenericDTO, bindingResult);
        String page = "";
        String role = userGenericDTO.getRole();
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("user", new UserGenericDTO());
            model.addAttribute("userType", userGenericDTO.getRole());
            return "login";
        }
        UserGenericDTO userForListing = userFacade.doLogin(userGenericDTO);
        if (userForListing.getEmail().equals(null)) {
            model.addAttribute("errors", "User or password incorrect/ or desired type of login are not allowed");
            page = "login";
        } else {
            session.setAttribute("currentUser", userForListing);
            model.addAttribute("currentUser", userForListing);
            page = userFacade.getPageForType(role);
        }

        return page;
    }


}
