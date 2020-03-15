package com.herokuapp.it372finalproject.restfulservices.controllers;

import com.herokuapp.it372finalproject.restfulservices.model.SubscribeForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConsumeController {

//    @RequestMapping("/consume")
//    public String showHome(Model model)
//    {
//        return "consume";
//    }

    @GetMapping("/consume")
    public String subscribeForm(Model model)
    {
        model.addAttribute("subscribe", new SubscribeForm());
        return "consume";
    }

    @PostMapping("/consume")
    public String subscribeSubmit(@ModelAttribute SubscribeForm subscribe, Model model)
    {
        model.addAttribute("subscribe", subscribe);
        return "result";
    }
}
