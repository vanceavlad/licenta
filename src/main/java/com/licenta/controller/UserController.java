package com.licenta.controller;


import com.licenta.dto.UserGenericDTO;
import com.licenta.facade.UserFacade;
import com.licenta.model.Allergy;
import com.licenta.service.AllergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    AllergyService allergyService;

    @Autowired
    UserFacade userFacade;

    @RequestMapping(value = "/myProfile", method = RequestMethod.GET)
    public String myProfile(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        UserGenericDTO userGenericDTO = (UserGenericDTO) session.getAttribute("currentUser");
        model.addAttribute("currentUser", userGenericDTO);
        return "userProfile";
    }

    @RequestMapping(value = "/addAllergies", method = RequestMethod.GET)
    public String viewPageForAllergies(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserGenericDTO userGenericDTO = (UserGenericDTO) session.getAttribute("currentUser");
        userGenericDTO = userFacade.getUserByUniqueKey(userGenericDTO.getUniqKey());
        List<Allergy> allergies = allergyService.getAll();
        model.addAttribute("existedAllergies", userGenericDTO.getAllergies());
        model.addAttribute("allergiesForSelect", allergies);
        model.addAttribute("user", userGenericDTO);

        return "addAllergiesForUser";

    }

    @RequestMapping(value = "/addAllergies", method = RequestMethod.POST)
    public String updateProduct(@ModelAttribute() UserGenericDTO user,
                                @RequestParam(value = "allergyIds", required = false) List<String> allergyIds,
                                BindingResult bindingResult, Model model) {


        String goToPage = "redirect:/user/myProfile";
//        if(allergyIds != null) {
            userFacade.addAllergiesForUser(user, allergyIds);
//            goToPage="redirect:/user/myProfile";
//        }

        return goToPage;

    }





}
