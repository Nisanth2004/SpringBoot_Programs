package com.nisanth.SpringJpaAuth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashBoardController
{
    @GetMapping("/")
    public String hello()
    {
        return "Welcome to Nisanth Selvaraj world";
    }

    @GetMapping("/admin")
    public String admin()
    {
        return "You can view only you are admin in the school";
    }

    @GetMapping("/staff")
    public String staff()
    {
        return "You can view only you are staff or admin in the school";
    }

}
