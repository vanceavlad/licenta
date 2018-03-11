package com.licenta.controller;

import com.licenta.dto.DoctorDTO;
import com.licenta.dto.FileForUserDTO;
import com.licenta.dto.UserDTO;
import com.licenta.facade.FileForUserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/files")
public class FilesForUserControler {

    @Autowired
    FileForUserFacade fileForUserFacade;



    @RequestMapping(value = "/addFileForUser",method = {RequestMethod.GET, RequestMethod.POST})
    public String addFileForm(@RequestParam("email") String email,
                              Model model, HttpServletRequest request){


        HttpSession session = request.getSession();

        DoctorDTO doctor = (DoctorDTO) session.getAttribute("currentDoctor");

        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);

        FileForUserDTO file = new FileForUserDTO();
        file.setUserEmail(email);


        model.addAttribute("user", userDTO);
        model.addAttribute("file", file);

        return "addFileForUser";
    }


    @RequestMapping(value = "/addFileForUserPost",method = {RequestMethod.GET, RequestMethod.POST})
    public String addFile(@ModelAttribute("file") FileForUserDTO fileForUserDTO,

                          BindingResult bindingResult, HttpServletRequest request){

        HttpSession session = request.getSession();

        DoctorDTO doctor = (DoctorDTO) session.getAttribute("currentDoctor");
        fileForUserDTO.setDoctorEmail(doctor.getEmail());

        fileForUserFacade.createNewFileForUser(fileForUserDTO);


        return "addFileForUser";
    }

    @RequestMapping(value = "/viewFile/{code}", method = RequestMethod.GET)
    public String viewPageForUpdate(@PathVariable String code, Model model) {
        String goToPage = "";
        FileForUserDTO fileForUserDTO = fileForUserFacade.findFileByCode(code);
//        List<Category> categoriesExisted = productEditDTO.getCategories();

        if (!fileForUserDTO.getFileCode().equals("")) {

            goToPage = "viewFile";
            model.addAttribute("file", fileForUserDTO);
        } else {
            goToPage = "codeNotExist";
        }

        return goToPage;
    }



    @RequestMapping(value = "/viewFileFromDoctorView/{code}", method = RequestMethod.GET)
    public String viewDetailsForFileFromDoctor(@PathVariable String code, Model model) {
        String goToPage = "";
        FileForUserDTO fileForUserDTO = fileForUserFacade.findFileByCode(code);
//        List<Category> categoriesExisted = productEditDTO.getCategories();

        if (!fileForUserDTO.getFileCode().equals("")) {

            goToPage = "viewFileFromDoctor";
            model.addAttribute("file", fileForUserDTO);
        } else {
            goToPage = "codeNotExist";
        }

        return goToPage;
    }






}
