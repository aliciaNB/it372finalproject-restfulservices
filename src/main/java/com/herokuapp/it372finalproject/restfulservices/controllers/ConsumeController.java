package com.herokuapp.it372finalproject.restfulservices.controllers;

import javax.validation.Valid;

import com.herokuapp.it372finalproject.restfulservices.model.SubscribeForm;
import com.herokuapp.it372finalproject.restfulservices.services.mailchimp.MailChimpAPI;
import com.herokuapp.it372finalproject.restfulservices.services.mailchimp.Subscriber;
import com.herokuapp.it372finalproject.restfulservices.services.mailchimp.Tags;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.bind.annotation.RequestMapping;

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
            boolean result = subscribeToNewsletter(subscribe.getEmail(), subscribe.getFname(), subscribe.getLname());

           if (result) {
               return "result";
           }
           else
           {
               bindingResult.reject("global", "Unable to subscribe " + subscribe.getEmail() + ". Please check email provided is valid");
               return "consume";
           }
        }
    }

    //This method handles adding a new MailChimp Newsletter subscriber
    private boolean subscribeToNewsletter(String email, String fname, String lname)
    {
        RestTemplateBuilder build = new RestTemplateBuilder();
        MailChimpAPI service = new MailChimpAPI(build);

        try
        {
            //check if already subscribed
            Subscriber subscriber = service.checkStatus(email);
            //if already subscribed, do nothing...
        }
        catch (HttpClientErrorException ex) // catch 404 not found error, means user is not in the contact list, add
        {
            try
            {
                Subscriber newSubscriber = service.subscribeToMailingList(email, fname, lname);

                //Tags newTags = service.addNewsletterTag(email);
                ResponseEntity<Tags> entity = service.addNewsletterTag(email);

                if (entity.getStatusCode().equals(HttpStatus.NO_CONTENT)) //Http 204 indicates that the request has succeeded
                {
                    return true;
                }
            }
            catch (HttpClientErrorException ex1)
            {
                return false;
            }
        }
        return false;
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
