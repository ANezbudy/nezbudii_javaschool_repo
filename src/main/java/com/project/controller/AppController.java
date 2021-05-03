package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class AppController {
    @RequestMapping("/admin")
    public ModelAndView greetAdmin() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("passenger");
        return mv;
    }

    @RequestMapping("/user")
    public ModelAndView greetUser() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("trip");
        mv.addObject("result", "Welcom, user!");
        return mv;
    }

    @RequestMapping("/myLoginPage")
    public String loginPage() {
        return "loginPage";
    }

}
