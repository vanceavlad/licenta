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


    @RequestMapping(value = "errorsPage", method = RequestMethod.GET)
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {
        ModelAndView errorPage = new ModelAndView("errorsPage");
        String errorMsg = "";
        int httpErrorCode = getErrorCode(httpRequest);
        switch (httpErrorCode) {
            case 400: {
                errorMsg = "Http Error Code: 400. Bad Request.";
                break;
            }
            case 401: {
                errorMsg = "Http Error Code: 401. Unauthorized.";
                break;
            }
            case 404: {
                errorMsg = "Http Error Code: 404. Page not found." +'\n';
                errorMsg += "Please check the URL to be correct";
                break;
            }
            case 405: {
                errorMsg ="Http Error Code : 405. Failed to load resource." + System.lineSeparator();
                errorMsg += "The method specified in the Request-Line is not allowed for the resource identified by the Request-URI." + System.lineSeparator();
                errorMsg += "Please check the URL to be correct. " + System.lineSeparator();
                System.out.println(errorMsg);
                break;
            }
            case 500: {
                errorMsg = "Http Error Code: 500. Internal Server Error.";
                break;
            }
        }
        errorPage.addObject("errorMsg", errorMsg);
        return errorPage;
    }

    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest
                .getAttribute("javax.servlet.error.status_code");
    }
}
