package com.licenta.facade.populator;

import com.licenta.dto.ZoneDTO;
import com.licenta.model.Zone;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ZonePopulator {


    public ZoneDTO zoneFromModelToDTO(Zone zone){
        ZoneDTO zoneDTO = new ZoneDTO();
        if(zone!=null){
            zoneDTO.setName(zone.getName());
        }
        return zoneDTO;
    }


    public List<String> zoneFromModelToDTOS(List<Zone> zones){
        List<String> zonesGenericDTO = new ArrayList<>();
        ZoneDTO zoneDTO = new ZoneDTO();
        if(zones!=null && (!zones.isEmpty())){
            for (Zone zone: zones) {
                zoneDTO = zoneFromModelToDTO(zone);
                zonesGenericDTO.add(zoneDTO.getName());
            }

        }
        return zonesGenericDTO;
    }
}
