package com.licenta.controller;


import com.licenta.dto.UserGenericDTO;
import com.licenta.model.Allergy;
import com.licenta.service.AllergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    AllergyService allergyService;

    @RequestMapping(value = "/myProfile", method = RequestMethod.GET)
    public String myProfile(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        UserGenericDTO userGenericDTO = (UserGenericDTO) session.getAttribute("currentUser");
        model.addAttribute("currentUser", userGenericDTO);
        return "userProfile";
    }

    @RequestMapping(value = "/addAlergies", method = RequestMethod.GET)
    public String viewPageForAllergies(Model model) {
        List<Allergy> allergies = allergyService.getAll();
        model.addAttribute("allergies", allergies);
        model.addAttribute("user", new UserGenericDTO());

        return "addAllergiesForUser";

    }
}
