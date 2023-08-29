package com.studentdetail.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_detail")
public class Student {

	@Id
 	@Column(name="student_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="student_name")
	private String StudentName;
	
	@Column(name="age")
	private int age;
	
	@Column(name="class_name")
	private String className;
	
	@Column(name="e_mail")
	private String email;
	
	public Student() 
	{
	
	}

	public Student(int id, String StudentName, int age, String className, String email) {
		super();
		this.id = id;
		this.StudentName = StudentName;
		this.age = age;
		this.className = className;
		this.email = email;
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String StudentName) {
		this.StudentName = StudentName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}


