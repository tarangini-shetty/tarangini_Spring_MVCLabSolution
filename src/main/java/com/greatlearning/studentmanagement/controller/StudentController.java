package com.greatlearning.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.studentmanagement.entity.Student;
import com.greatlearning.studentmanagement.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService StudentService;
	
	@RequestMapping("/list")
	public String listStudent(Model themodel) {
		List<Student> theStudents= StudentService.findAll();
		themodel.addAttribute("students", theStudents);
		return "list-students";
		
	}
	
	@RequestMapping("/showFormForAdd")
	public String ShowFormForAdd(Model themodel) {
		Student student = new Student();
		themodel.addAttribute("student",student);
		themodel.addAttribute("mode","Add");
		return "student-form";
	}
	
	
	@RequestMapping("/showFormForUpdate")
	public String ShowFormForUpdate(@RequestParam("studentId") long studentId, Model themodel) {
		Student student = StudentService.findById(studentId);
		themodel.addAttribute("student",student);
		themodel.addAttribute("mode", "Update");				
		return "student-form";		
	}
	
	@PostMapping("/save")
	public String saveStudent(@RequestParam("studentId") long studentid, @RequestParam("firstName") String firstname,
			@RequestParam("lastName") String lastname,
			@RequestParam("course") String course,
			@RequestParam("country") String country) {
		
		Student student = null;
		if(studentid == 0) {
			student = new Student(firstname, lastname, course, country);		
		}
		else {
			student = StudentService.findById(studentid);
			student.setFirstname(firstname);
			student.setCountry(country);
			student.setCourse(course);
			student.setLastname(lastname);
		}
		StudentService.save(student);
		return "redirect:list";
		
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") long studentId) {
		StudentService.delete(studentId);
		return "redirect:list";
		
	}
	

}
