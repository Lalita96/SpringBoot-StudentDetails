package com.studentdetail.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.studentdetail.demo.controller.AddStudentResponse;
import com.studentdetail.demo.model.Student;
import com.studentdetail.demo.repository.StudentRepository;

@Component
@Service
public class StudentService 
{
	@Autowired
	StudentRepository studentRepository;
		
		public Student addStudent(Student student)
		{
			return studentRepository.save(student);
		}
		
		public List<Student> getAllStudents()
		{
			return studentRepository.findAll();
		}
		
		public Student getStudentById(int id)
		{
			List<Student> students = studentRepository.findAll();
			Student student = null;
			for(Student std : students) 
			{
				if(std.getId()==id)
				{
					student=std;
				}
			}
			return student;
		}
		
		public Student getStudentByName(String StudentName)
		{
			List<Student> students = studentRepository.findAll();
			Student student=null;
			for(Student std : students)
			{
				if(std.getStudentName().equalsIgnoreCase(StudentName))
				{
					student=std;
				}
			}
			return student;
		}
	
		public AddStudentResponse DeleteStudent(int id)
		{
			studentRepository.deleteById(id);
			AddStudentResponse addresponse = new AddStudentResponse();
			addresponse.setMsg("Student's Detail Deleted...... ");
			addresponse.setId(id);
			return addresponse;
		}
		
		public Student UpdateStudentDetails(Student student)
		{
			studentRepository.save(student);
			return student;
			
		}
}
