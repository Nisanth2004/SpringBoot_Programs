package com.springjwt.jwt.service;

import com.springjwt.jwt.controller.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMemoryService
{
   public List<UserDetails> users()
   {
       UserDetails u1=new User("Nisanth","1234","ADMIN");
       UserDetails u2=new User("Sujith","123","MANAGER");
       return List.of(u1,u2);


       }
   }

