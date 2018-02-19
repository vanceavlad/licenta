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
        return allergyPopulator.allergyFromModelToDTOS(categories);
    }

    public void createAllergy(AllergyDTO allergyDTO) {
        Allergy allergy =allergyReversePopulator.allergyDTOToModel(allergyDTO);
        allergyService.createAllergy(allergy);
    }

    public AllergyDTO findCategoryById(Integer id) {
        Allergy allergy = allergyService.findAllergyById(id);
        return allergyPopulator.allergyFromModelToDTO(allergy);

    }

    public void updateCategory(AllergyDTO oldAllergy, AllergyDTO newAllergy) {
        Allergy oAllergy =  allergyReversePopulator.allergyDTOToModel(oldAllergy);
        Allergy nAllergy =  allergyReversePopulator.allergyDTOToModel(newAllergy);
        allergyService.updateAllergy(oAllergy,nAllergy);
    }
}
