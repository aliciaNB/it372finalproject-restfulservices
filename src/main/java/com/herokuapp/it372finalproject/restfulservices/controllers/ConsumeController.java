package com.herokuapp.it372finalproject.restfulservices.controllers;

import javax.validation.Valid;

import com.herokuapp.it372finalproject.restfulservices.model.SubscribeForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class ConsumeController {

    @GetMapping("/consume")
    public String subscribeForm(Model model)
    {
        model.addAttribute("subscribe", new SubscribeForm());
        return "consume";
    }

    @PostMapping("/consume")
    public String subscribeSubmit(@Valid @ModelAttribute("subscribe") SubscribeForm subscribe,
                                  BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors())
        {
            return "consume";
        }
        else
        {
            model.addAttribute("subscribe", subscribe);
            return "result";
        }
    }

//    @RequestMapping("/consume")
//    public String showHome(Model model)
//    {
//        return "consume";
//    }

//    @PostMapping("/consume")
//    public String subscribeSubmit(@ModelAttribute SubscribeForm subscribe, Model model)
//    {
//        model.addAttribute("subscribe", subscribe);
//        return "result";
//    }
}
