package ar.edu.itba.paw.webapp.controller;

import ar.edu.itba.paw.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public ModelAndView helloWorld(){
        final ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("greeting", userService.list().get(0).getName());
        return modelAndView;
    }

}
