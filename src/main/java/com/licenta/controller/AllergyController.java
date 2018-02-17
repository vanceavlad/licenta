package com.licenta.controller;


import com.licenta.dto.AllergyDTO;
import com.licenta.facade.AllergyFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("allergies")
public class AllergyController {


    @Autowired
    AllergyFacade allergyFacade;




    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAllergies() {
        ModelAndView modelAndView = new ModelAndView("viewAllergies");
        List<AllergyDTO> allergies = allergyFacade.getAllAllergies();
        modelAndView.addObject("allergies", allergies);
        return modelAndView;
    }



    @RequestMapping(value = "/addAllergy", method = RequestMethod.GET)
    public String addAllergy(){
        return "addAllergyFromAdmin";
    }


    @RequestMapping(value = "/addAllergy", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute AllergyDTO allergyDTO){
        allergyFacade.createAllergy(allergyDTO);
        return new ModelAndView("redirect:/allergies");
    }


    @RequestMapping(value = "/editAllergy/{id}", method = RequestMethod.GET)
    public ModelAndView viewPageForUpdate(@PathVariable Integer id) {
        AllergyDTO oldAllergy = allergyFacade.findCategoryById(id);
        ModelAndView modelAndView = new ModelAndView("editAllergy");
        modelAndView.addObject("oldAllergy", oldAllergy);
        modelAndView.addObject("newAllergy", oldAllergy.getName());
        return modelAndView;
    }

    @RequestMapping(value = "/editAllergy", method = RequestMethod.POST)
    public ModelAndView updateCategory(@RequestParam("oldAllergy") Integer oldAllergy,
                                       @RequestParam("newAllergy") String newAllergy) {
        try {
            System.out.println(oldAllergy);
            allergyFacade.updateCategory(allergyFacade.findCategoryById(oldAllergy), new AllergyDTO(newAllergy));
            return new ModelAndView("redirect:/allergies");
        }catch (Exception ex){
            return new ModelAndView("redirect:/allergies");
        }
    }
}
