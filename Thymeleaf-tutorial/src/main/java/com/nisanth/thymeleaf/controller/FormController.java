package com.nisanth.thymeleaf.controller;

import com.nisanth.thymeleaf.model.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class FormController {

    // handler method to handle user registration page request
    @GetMapping("register")
    public String userPage(Model model)
    {
        //Empty Userform model object to store form data
        UserForm userForm=new UserForm();
        model.addAttribute("userForm",userForm);

        List<String> listProfession= Arrays.asList("Devleoper,Tester,Devops");
        model.addAttribute("listProfession",listProfession);
        return "register-form";
    }

    // handel form-submission
    @PostMapping("register/save")
    public String submitForm(Model model, @ModelAttribute("userForm") UserForm userForm)
    {
        model.addAttribute("userForm",userForm);
        return "register-success";
    }
}

