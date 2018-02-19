package com.licenta.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController {


    @RequestMapping(value = "/errors", method = RequestMethod.GET)
    public ModelAndView errorPage(HttpServletRequest httpServletRequest) {


        ModelAndView errorPage = new ModelAndView("errorPage");

        return errorPage;
    }
}
