package com.nisanth;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//   Dependency Injection Demo


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext context=	SpringApplication.run(DemoApplication.class, args);
	
	Alien a=context.getBean(Alien.class);
	a.show();
	
	/*
	 * prototype scope will be create obj when we are asked only
	 * but in Singleton scope it will  create when we are start running
	 * 
	Alien a1=context.getBean(Alien.class);
	a1 .show();
	
	*/
	}

}
