package com.licenta.facade.reversepopulator;

import com.licenta.dto.AllergyDTO;
import com.licenta.dto.ZoneDTO;
import com.licenta.model.Allergy;
import com.licenta.model.Zone;
import org.springframework.stereotype.Component;

@Component
public class ZoneReversePopulator {


    public Zone zoneDTOToModel(ZoneDTO zoneDTO){
        Zone zone = new Zone();
        if(zoneDTO!=null){
            zone.setName(zoneDTO.getName());
//            zone.setId(zoneDTO.getId());
        }
        return zone;
    }
}
