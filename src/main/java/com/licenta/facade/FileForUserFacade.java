package com.licenta.facade;

import com.licenta.dto.FileForUserDTO;
import com.licenta.facade.populator.FilesForUserPopulator;
import com.licenta.facade.reversepopulator.FileForUserReversePopulator;
import com.licenta.model.FileForUser;
import com.licenta.service.FileForUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileForUserFacade {


    @Autowired
    FileForUserService fileForUserService;

    @Autowired
    FileForUserReversePopulator fileForUserReversePopulator;

    @Autowired
    FilesForUserPopulator filesForUserPopulator;

    public void createNewFileForUser(FileForUserDTO fileForUserDTO){
        FileForUser fileModel = fileForUserReversePopulator.fileDTOToModel(fileForUserDTO);
        fileForUserService.createNewFileForUser(fileModel);
    }


    public FileForUserDTO findFileByCode(String code) {
        FileForUser file = fileForUserService.findFileByCode(code);
        FileForUserDTO fileForUserDTO = filesForUserPopulator.fileForUserModelToDTO(file);
        return fileForUserDTO;
    }
}
