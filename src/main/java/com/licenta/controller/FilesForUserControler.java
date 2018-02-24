package com.licenta.controller;

import com.licenta.dto.FileForUserDTO;
import com.licenta.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/files")
public class FilesForUserControler {




    @RequestMapping(value = "/addFileForUser",method = {RequestMethod.GET, RequestMethod.POST})
    public String addFileForm(@RequestParam("email") String email,
                              Model model){


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

                          BindingResult bindingResult){


        return "addFileForUser";
    }








}
