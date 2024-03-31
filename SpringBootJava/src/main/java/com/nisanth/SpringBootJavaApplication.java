package com.nisanth;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nisanth.sub1.SpringComponent;

@SpringBootApplication
public class SpringBootJavaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =SpringApplication. run(SpringBootJavaApplication.class, args);
		SpringComponent component=applicationContext.getBean(SpringComponent.class);
		System.out.println(component.getMessage());
		System.out.println("Hello World  ..");
	}

}
