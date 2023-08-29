package com.studentdetail.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentdetail.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
