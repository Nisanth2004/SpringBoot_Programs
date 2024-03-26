package com.nisanth.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nisanth.springboot.model.Student;

@RestController
public class StudentController
{
	private List<Student> students = new ArrayList();

	@GetMapping("/students")
	public List<Student> students() 
	{

		Student student1 = new Student();
		student1.setId(1);
		student1.setFirstName("Nisanth");
		student1.setLastName("selvaraj");

		Student student2 = new Student();
		student2.setId(2);
		student2.setFirstName("Sujith");
		student2.setLastName("selvaraj");

		students.add(student2);
		students.add(student1);

		return students;
	}
    
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student)
	{
		students.add(student);
		return student;
	}
}
