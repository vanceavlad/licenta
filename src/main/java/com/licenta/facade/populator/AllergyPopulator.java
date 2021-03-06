package com.licenta.facade.populator;


import com.licenta.dto.AllergyDTO;
import com.licenta.model.Allergy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AllergyPopulator {


    public AllergyDTO allergyFromModelToDTO(Allergy allergy){
        AllergyDTO allergyDTO = new AllergyDTO();
        if(allergy!=null){
            allergyDTO.setName(allergy.getName());
            allergyDTO.setId(allergy.getId());
        }
        return allergyDTO;
    }


    public List<AllergyDTO> allergyFromModelToDTOS(List<Allergy> allergies){
        List<AllergyDTO> allergiesGenericDTO = new ArrayList<>();
        if(allergies!=null && (!allergies.isEmpty())){
            for (Allergy allergy: allergies) {
                allergiesGenericDTO.add(allergyFromModelToDTO(allergy));
            }

        }
        return allergiesGenericDTO;
    }


}
