package com.licenta.facade.reversepopulator;


import com.licenta.dto.AllergyDTO;
import com.licenta.model.Allergy;
import org.springframework.stereotype.Component;

@Component
public class AllergyReversePopulator {

    public Allergy allergyDTOToAllergyModel(AllergyDTO allergyDTO){
        Allergy category = new Allergy();
        if(allergyDTO!=null){
            category.setName(allergyDTO.getName());
            category.setId(allergyDTO.getId());
        }
        return category;
    }

}
