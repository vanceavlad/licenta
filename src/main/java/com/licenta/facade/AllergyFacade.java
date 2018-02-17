package com.licenta.facade;


import com.licenta.dto.AllergyDTO;
import com.licenta.facade.populator.AllergyPopulator;
import com.licenta.facade.reversepopulator.AllergyReversePopulator;
import com.licenta.model.Allergy;
import com.licenta.service.AllergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllergyFacade {

    @Autowired
    private AllergyPopulator allergyPopulator;

    @Autowired
    private AllergyReversePopulator allergyReversePopulator;

    @Autowired
    private AllergyService allergyService;


    public List<AllergyDTO> getAllAllergies() {

        List<Allergy> categories = allergyService.getAll();
        return allergyPopulator.allergyModelToGenericDTOS(categories);
    }

    public void createAllergy(AllergyDTO allergyDTO) {
        Allergy allergy =allergyReversePopulator.allergyDTOToAllergyModel(allergyDTO);
        allergyService.createAllergy(allergy);
    }

    public AllergyDTO findCategoryById(Integer id) {
        Allergy allergy = allergyService.findAllergyById(id);
        return allergyPopulator.allergyModelToGenericDTO(allergy);

    }

    public void updateCategory(AllergyDTO oldAllergy, AllergyDTO newAllergy) {
        Allergy oAllergy =  allergyReversePopulator.allergyDTOToAllergyModel(oldAllergy);
        Allergy nAllergy =  allergyReversePopulator.allergyDTOToAllergyModel(newAllergy);
        allergyService.updateAllergy(oAllergy,nAllergy);
    }
}
