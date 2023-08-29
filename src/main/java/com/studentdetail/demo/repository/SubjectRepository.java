package com.studentdetail.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.studentdetail.demo.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer>
{

}
