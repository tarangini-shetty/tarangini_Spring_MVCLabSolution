package com.greatlearning.studentmanagement.service;
import java.util.List;

import com.greatlearning.studentmanagement.entity.Student;

public interface StudentService {
	
	public List<Student> findAll();
	public Student findById(long studentid);
	public void save(Student student);
	public void delete(long studentid);

}
