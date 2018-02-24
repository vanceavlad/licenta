package com.licenta.facade.reversepopulator;


import com.licenta.dto.AllergyDTO;
import com.licenta.dto.FileForUserDTO;
import com.licenta.model.Allergy;
import com.licenta.model.FileForUser;
import com.licenta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileForUserReversePopulator {

    @Autowired
    UserService userService;

    public FileForUser fileDTOToModel(FileForUserDTO fileForUserDTO){
        FileForUser file = new FileForUser();
        if(fileForUserDTO!=null){
            file.setDescription(fileForUserDTO.getDescription());
            file.setDate(fileForUserDTO.getDate());
            file.setProblems(fileForUserDTO.getProblems());
            file.setUtilities(fileForUserDTO.getUtilities());
            file.setUser(userService.getUserByEmail(fileForUserDTO.getUserEmail()));
            file.setDoctor(fileForUserDTO.getDoctorEmail());
            file.setFileCode(fileForUserDTO.getFileCode());
        }
        return file;
    }

}
