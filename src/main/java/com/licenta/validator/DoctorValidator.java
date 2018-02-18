package com.licenta.validator;

import com.licenta.dto.UserGenericDTO;
import com.licenta.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class DoctorValidator implements Validator {

    @Autowired
    DoctorService doctorService;
    
    
    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object objectDoctor, Errors errors) {
        UserGenericDTO user = (UserGenericDTO) objectDoctor;

        ValidationUtils.rejectIfEmpty(errors,"email", "email.empty", "Email cannot be empty");

        if(notExistsEmail(user.getEmail())){
            errors.rejectValue("email", "email.taken", "Email is not exists!");
        }

    }

    private boolean notExistsEmail(String email) {
        return doctorService.notExistsEmail(email);
    }
}
