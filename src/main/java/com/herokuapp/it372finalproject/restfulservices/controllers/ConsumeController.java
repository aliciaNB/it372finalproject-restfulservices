package com.herokuapp.it372finalproject.restfulservices.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConsumeController {

    @RequestMapping("/consume")
    public String showHome(Model model)
    {
        return "consume";
    }
}
