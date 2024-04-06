package com.nisanth.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nisanth.springboot.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
