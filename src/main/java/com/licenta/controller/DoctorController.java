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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    UserFacade userFacade;


    @RequestMapping(value = "/myProfile", method = RequestMethod.GET)
    public String myProfile(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserGenericDTO userGenericDTO = (UserGenericDTO) session.getAttribute("currentUser");
        model.addAttribute("currentUser", userGenericDTO);
        model.addAttribute("searchedUser", new UserGenericDTO());
        return "doctorProfile";
    }


    @RequestMapping(value = "/searchUser", method = RequestMethod.POST)
    public String Search(@ModelAttribute("searchedUser") UserGenericDTO searchedUser, Model model, BindingResult bindingResult) {

        String goToPage = "";
        UserGenericDTO userForListing = userFacade.getUserByUniqueKey(searchedUser.getUniqKey());

        if (userForListing != null) {
            model.addAttribute("resultUser", userForListing);
            model.addAttribute("existedAllergies", userForListing.getAllergies());
//            model.addAttribute("resultUser", userForListing);
            goToPage = "searchedUserDetails";
        } else {
            bindingResult.rejectValue("uniqueKey", "uniqueKey.empty", "User with unique id enteredis not exists!");
            goToPage = "doctorProfile";
        }
        return goToPage;
    }
}
