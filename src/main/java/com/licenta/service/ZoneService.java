package com.licenta.service;

import com.licenta.model.Allergy;
import com.licenta.model.Zone;
import com.licenta.repository.ZoneDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ZoneService {

    @Autowired
    ZoneDaoImpl zoneDao;

    public List<Zone> getAll() {
        return zoneDao.getAll();
    }

}
