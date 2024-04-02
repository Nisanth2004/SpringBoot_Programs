package com.nisanth.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackend1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackend1Application.class, args);
		Student s=new Student();
	s.setId(4);
	System.out.println(s.getId());
	
	}

}
