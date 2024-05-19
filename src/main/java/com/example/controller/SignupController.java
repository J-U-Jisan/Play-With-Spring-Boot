package com.example.controller;

import com.example.application.service.UserApplicationService;
import com.example.form.SignupForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping("/user")
@Slf4j
public class SignupController {

    @Autowired
    private UserApplicationService userApplicationService;

    /** Display the user signup screen */
    @GetMapping ("/signup")
    public String getSignup(Model model, Locale locale, @ModelAttribute SignupForm form) {

        // Get gender
        Map<String, Integer> genderMap = userApplicationService.getGenderMap(locale);
        model.addAttribute("genderMap", genderMap);
        // Transition to user signup screen
        return "user/signup";
    }

    /** User signup process */
    @PostMapping ("/signup")
    public String postSignup(Model model, Locale locale, @ModelAttribute @Validated SignupForm form, BindingResult bindingResult) {

        // Input check result
        if (bindingResult.hasErrors()) {
            return getSignup(model, locale, form);
        }

        log.info(form.toString());
        // Redirect to login screen
        return "redirect:/login";
    }
}
