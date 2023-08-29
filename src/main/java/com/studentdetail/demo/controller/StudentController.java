package com.studentdetail.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentdetail.demo.model.Student;
import com.studentdetail.demo.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/addstudent")
	public Student addstudent(@RequestBody Student student)
	{
		return studentService.addStudent(student);
	}
	
	@GetMapping("/getstudents")
	public List<Student> getStudents()
	{
		return studentService.getAllStudents();
	}
	
	@GetMapping("/getstudentsbyid/{id}")
	public ResponseEntity<Student> getStudentbyid(@PathVariable(value="id") int id)
	{
		try 
		{
			Student student = studentService.getStudentById(id);
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getstudentbyname")
	public ResponseEntity<Student> getStudentbyName(@RequestParam(value="StudentName") String StudentName)
	{
		try
		{
			Student student = studentService.getStudentByName(StudentName);
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		}
		catch (Exception e) 
		{
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/deletestudent/{id}")
	public AddStudentResponse deleteStudent(@PathVariable(value="id") int id)
	{
		return studentService.DeleteStudent(id);
	}
	
	@PutMapping("UpdateStudent/{id}")
	public ResponseEntity<Student> updateStudentdetail(@PathVariable(value="id") int id, @RequestBody Student student)
	{
		try 
		{
			Student oldstudent = studentService.getStudentById(id);
			oldstudent.setStudentName(student.getStudentName());
			oldstudent.setAge(student.getAge());
			oldstudent.setClassName(student.getClassName());
			oldstudent.setEmail(student.getEmail());
			
			Student new_student = studentService.UpdateStudentDetails(oldstudent);
			return new ResponseEntity<Student>(new_student, HttpStatus.OK);
			
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<Student>(HttpStatus.CONFLICT);
			// TODO: handle exception
		}
	}
}
