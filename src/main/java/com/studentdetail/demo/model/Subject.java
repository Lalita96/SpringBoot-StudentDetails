package com.studentdetail.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="subject_detail")
public class Subject 
{
	
	
	@Id
	@Column(name="subject_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="subject_name")
	private String subjectName;
	
	@ManyToOne
	private Student student;

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
