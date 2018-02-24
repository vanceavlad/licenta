package com.licenta.facade.populator;

import com.licenta.dto.FileForUserDTO;
import com.licenta.model.FileForUser;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

@Component
public class FilesForUserPopulator {

    public FileForUserDTO fileForUserModelToDTO(FileForUser fileForUser){
        FileForUserDTO fileForUserDTO = new FileForUserDTO();
        if(fileForUser!=null){

            fileForUserDTO.setDescription(fileForUser.getDescription());
            fileForUserDTO.setProblems(fileForUser.getProblems());
            fileForUserDTO.setUserEmail(fileForUser.getUser().getEmail());
            fileForUserDTO.setUtilities(fileForUser.getUtilities());
            fileForUserDTO.setDate(fileForUser.getDate());
            fileForUserDTO.setFileCode(fileForUser.getFileCode());
            fileForUserDTO.setDoctorEmail(fileForUser.getDoctor());
        }
        return fileForUserDTO;
    }

    public Set<FileForUserDTO> fileForUserModelToDTOS(Set<FileForUser> filesForUser){
        Set<FileForUserDTO> fileForUserDTOS = new HashSet<>();
        if(filesForUser!=null && !filesForUser.isEmpty()){
            for(FileForUser file : filesForUser){
                fileForUserDTOS.add(this.fileForUserModelToDTO(file));
            }
        }
        return fileForUserDTOS;
    }

}
