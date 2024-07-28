package com.nisanth.thymeleaf.controller;

import com.nisanth.thymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {


    @GetMapping("variable-expressions")
    public String hello(Model model)
    {
        User user=new User("Nisanth","Male","Email","Admin");
        System.out.println(user);
        model.addAttribute("user",user);
        return "variable-expression";
    }

    @GetMapping("selection-expression")
    public String helloworld(Model model)
    {
        User user=new User("Nisanth","Male","Email","Admin");
        System.out.println(user);
        model.addAttribute("user",user);
        return "selection-expressions";

    }


    @GetMapping("/users")
    public String users(Model model)
    {
        User admin=new User("Admin","Male","admin@gmail.com","ADMIN");
        User nisanth=new User("NISANTH","Male","nisanth@gmail.com","USER");
        User Sandhiya=new User("SANDHIYA","Female","admin@gmail.com","USER");
        List<User> users=new ArrayList<>();
        users.add(admin);
        users.add(nisanth);
        users.add(Sandhiya);
        model.addAttribute("users",users);
        return "users";
    }


    @GetMapping("/if-unless")
    public String ifUnless(Model model)
    {
        User admin=new User("Admin","Male","admin@gmail.com","ADMIN");
        User nisanth=new User("NISANTH","Male","nisanth@gmail.com","USER");
        User Sandhiya=new User("SANDHIYA","Female","admin@gmail.com","USER");
        List<User> users=new ArrayList<>();
        users.add(admin);
        users.add(nisanth);
        users.add(Sandhiya);
        model.addAttribute("users",users);
        return "if-unless";
    }
}
