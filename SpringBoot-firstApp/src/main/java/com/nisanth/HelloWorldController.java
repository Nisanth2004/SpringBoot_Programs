package com.nisanth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // combination of responsebody and controller
public class HelloWorldController 
{
	@GetMapping("/hello-world")  //i
   public String helloworld()
   {
	   return "Hello  is World";
   }
}  
