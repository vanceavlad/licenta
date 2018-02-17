package com.licenta.service;


import com.licenta.model.Allergy;
import com.licenta.repository.AllergyDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AllergyService {


    @Autowired
    private AllergyDaoImpl allergyDao;


    public List<Allergy> getAll() {
        return allergyDao.getAll();
    }


    public void createAllergy(Allergy allergy) {
        if (!allergy.getName().trim().equals("")) {
            allergyDao.create(allergy);
        }
    }

    public Allergy findAllergyById(Integer id) {
        return allergyDao.findById(id);
    }

    public void updateAllergy(Allergy oAllergy, Allergy nAllergy) {
        if (!nAllergy.getName().trim().equals("")) {
            Allergy allergy = allergyDao.findById(oAllergy.getId());
            allergy.setName(nAllergy.getName());
            allergyDao.update(allergy);
        }
    }
}
