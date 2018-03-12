package com.licenta.facade;


import com.licenta.dto.ZoneDTO;
import com.licenta.facade.populator.ZonePopulator;
import com.licenta.model.Zone;
import com.licenta.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ZoneFacade {

    @Autowired
    ZoneService zoneService;

    @Autowired
    ZonePopulator zonePopulator;

    public List<String> getAllZone(){
        List<Zone> zones =  zoneService.getAll();
        List<String> zonesDTO = zonePopulator.zoneFromModelToDTOS(zones);
        return zonesDTO;

    }
}
