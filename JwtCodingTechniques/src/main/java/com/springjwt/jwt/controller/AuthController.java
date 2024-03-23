package com.springjwt.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
public class AuthController
{
    Logger logger=Logger.getLogger(AuthController.class.getName());
    @Autowired
    private AuthenticationManager authenticationManager;
     @GetMapping("/home")
     @ResponseBody
    public String home()
     {
         return "home";
     }

     @GetMapping("/login-page")
    public String getLogin(@ModelAttribute("user") User user)
     {
         return "login";
     }

     @PostMapping("/login-page")
    public String postLogin(@ModelAttribute("user") User user, Model model)
     {
         String message="Invalid credential";
         logger.info("UserName:"+user.getUsername() );

         try
         {
             var  UsernamePasswordAuthenticationToken=authenticationManager
                     .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

         }
         catch (Exception e)
         {
             model.addAttribute("message",message);
             return "login";


         }

         return "login";
     }

}
