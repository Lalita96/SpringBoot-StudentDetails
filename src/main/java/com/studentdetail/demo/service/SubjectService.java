package com.studentdetail.demo.service;

import org.springframework.stereotype.Service;

import com.studentdetail.demo.model.Subject;
import com.studentdetail.demo.repository.SubjectRepository;

@Service
public class SubjectService {
		
	private SubjectRepository subjectRepository;
	

	public Subject addSubject(Subject subject) 
	{
		return subjectRepository.save(subject);
	}
}
