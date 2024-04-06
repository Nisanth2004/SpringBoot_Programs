package com.nisanth.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nisanth.springboot.entity.Student;
import com.nisanth.springboot.repository.StudentRepository;
import com.nisanth.springboot.service.StudentService;

@Service // to handle business logic
public class StudentServiceImpl implements StudentService 
{
      
	private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) 
	{
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		
		return studentRepository.findAll();
	}

}
