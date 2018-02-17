package com.licenta.controller;


import com.licenta.dto.AdminDTO;
import com.licenta.dto.UserGenericDTO;
import com.licenta.facade.AdminFacade;
import com.licenta.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/secret/admin/path")
public class AdminController {


    @Autowired
    AdminFacade adminFacade;


    @RequestMapping(value = "/registerAdminForm", method = RequestMethod.GET)
    public String getRegisterView(Model model) {
        model.addAttribute("admin", new AdminDTO());
        return "registerAdmin";
    }


    @RequestMapping(value = "/createAdmin", method = RequestMethod.POST)
    public String createUser(@ModelAttribute(name = "admin") AdminDTO adminDTO, BindingResult bindingResult,
                             Model model) {

        if (adminDTO.getEmail() != null && adminDTO.getPassword() != null) {
            adminFacade.createAdmin(adminDTO);
            model.addAttribute("admin", new AdminDTO());
            return "adminLoginForm";
        } else {
            return "registerAdmin";
    }
    }


    @RequestMapping(value = "/adminLoginForm", method = RequestMethod.GET)
    public ModelAndView getLoginForm() {
        ModelAndView modelAndView = new ModelAndView("adminLoginForm");
        modelAndView.addObject("admin", new AdminDTO());
        return modelAndView;
    }

    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public String doLoginForAdmin(@ModelAttribute(name = "admin") AdminDTO adminDTO, BindingResult bindingResult,
                                  Model model, HttpServletRequest request) {
        String page = "";

        AdminDTO userForListing = adminFacade.doLogin(adminDTO);
        if (userForListing != null) {
            model.addAttribute("errors", "User or password incorrect/ or desired type of login are not allowed");
            page = "adminPage";
        } else {
            page = "adminLoginForm";
        }

        return page;

    }


    @RequestMapping(value = "/adminPage", method = RequestMethod.GET)
    public String adminProfile() {

        return "adminPage";
    }



}
