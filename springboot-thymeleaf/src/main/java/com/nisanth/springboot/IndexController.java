package com.nisanth.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController 
{
	@GetMapping("home")
    public String indexPage(Model model)
	{
		model.addAttribute("abcd","Welcome to My Website");
		return "home";
	}
	
	@GetMapping("nisanthbs")
	public String realme(Model model)
	{
		model.addAttribute("nisanth","This is Realme");
		return "hi";
		
	}
}
