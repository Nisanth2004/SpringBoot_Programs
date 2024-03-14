package com.nisanth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController 
{
	
	// http://localhost:8080/student
	@GetMapping("/student")
    public Student getStudent()
    {
    	return new Student("Nisanth","Selvaraj");
    	
    }
	
	@GetMapping("/students")
	public List<Student> getStudents()
	{
		List<Student> students=new ArrayList<>();
		students.add(new Student("Kaaviyan","Selvaraj"));
		students.add(new Student("Kesavan","Ranganathan"));
		students.add(new Student("Sujith","Selvaraj"));
		students.add(new Student("Jothi","Selvaraj"));
		
		students.add(new Student("Praveen","Kannan"));
		return students;
	}
	
	// @PathVaribale annotations
	@GetMapping("/student/{firstname}/{lastname}") // URI template variable
	public Student studentPathVariable(@PathVariable("firstname")String firstname,
			@PathVariable("lastname") String lastname )
	{
		return new Student(firstname,lastname);
	}
	
	//build REST API to handgle query parameters
	// http://localhost:8080/student/query?firstname=Nisanth&lastname=Selvaraj
	@GetMapping("/student/query")
	public Student studentQueryParam(@RequestParam(name="firstname") String firstname,@RequestParam(name="lastname")String lastname)
	{
		return new Student(firstname,lastname);
	}
}
