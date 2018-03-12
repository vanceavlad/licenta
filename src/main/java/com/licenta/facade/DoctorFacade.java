package com.licenta.facade;

import com.licenta.dto.DoctorDTO;
import com.licenta.dto.FileForUserDTO;
import com.licenta.dto.UserDTO;
import com.licenta.dto.UserGenericDTO;
import com.licenta.facade.populator.DoctorPopulator;
import com.licenta.facade.populator.FilesForUserPopulator;
import com.licenta.facade.reversepopulator.DoctorReversePopulator;
import com.licenta.facade.reversepopulator.UserReversePopulator;
import com.licenta.model.Doctor;
import com.licenta.model.DoctorRequest;
import com.licenta.model.FileForUser;
import com.licenta.model.User;
import com.licenta.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Component
public class DoctorFacade {


    public static final String DOCTOR = "DOCTOR";
    public static final String USER = "USER";


    @Autowired
    private DoctorService doctorService;

    @Autowired
    UserReversePopulator userReversePopulator;

    @Autowired
    DoctorReversePopulator doctorReversePopulator;

    @Autowired
    DoctorPopulator doctorPopulator;

    @Autowired
    FilesForUserPopulator filesForUserPopulator;


    public List<DoctorRequest> connectUserWithDoctor(DoctorDTO doctorDTO, UserDTO userGeneric) {
        User user = userReversePopulator.userFromDTOToModel(userGeneric);
        Doctor doctor = doctorReversePopulator.doctorFromDTOToModel(doctorDTO);
        String email = doctor.getEmail();
        String result = doctorService.sendConnectingEmail(doctor, user);
        if (result != null) {
            return doctorService.createRequest(doctor, user);
        } else {
            return null;
        }
    }

    public boolean verifyIfDoctorHasUser(DoctorDTO doctor, UserDTO userForListing) {
        User userModel = userReversePopulator.userFromDTOToModel(userForListing);
        Doctor doctorModel = doctorReversePopulator.doctorFromDTOToModel(doctor);
        return doctorService.verifyIfDoctorHasUser(doctorModel, userModel);
    }

    public Integer addDoctor(DoctorDTO userGenericDTO) {
        Doctor doctor = doctorReversePopulator.doctorFromDTOToModel(userGenericDTO);
        return doctorService.create(doctor);
    }

    public DoctorDTO doLogin(DoctorDTO doctorDTO) {
        DoctorDTO doctorForListing = new DoctorDTO();
        if (doctorDTO.getRole().equals(DOCTOR)) {

            Doctor doctorFromServer = doctorService.loginDoctor(doctorDTO.getEmail(), doctorDTO.getPassword(),
                    doctorDTO.getRole());
            doctorForListing = doctorPopulator.doctorFromModelToDTO(doctorFromServer);
        }

        return doctorForListing;
    }

    public Set<FileForUserDTO> getFilesForUser(String key) {
        Set<FileForUser> filesForUser = doctorService.getAllFilesForUser(key);
        return filesForUserPopulator.fileForUserModelToDTOS(filesForUser);
    }

    public Set<FileForUserDTO> findUserAssociatedWithFileCode(String code) {
        Set<FileForUser> filesForUser = doctorService.findUserAssociatedWithFileCode(code);
        return filesForUserPopulator.fileForUserModelToDTOS(filesForUser);
    }

    public DoctorDTO findByKey(String uniqueKey) {
        Doctor doctor = doctorService.getByKey(uniqueKey);
        DoctorDTO doctorDTO = doctorPopulator.doctorFromModelToDTO(doctor);
        return doctorDTO;
    }
}
