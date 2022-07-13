package com.greatlearning.debateEvent.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.debateEvent.entity.Student;
import com.greatlearning.debateEvent.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentsController {
	
	@Autowired
	public StudentService studentService;
	
	// add mapping for "/list"
	@RequestMapping("/list")
	public String findAll(Model theModel) {
		
		// get Students from db
		List<Student> theStudents = studentService.findAll();
		
		// add to the spring model
		theModel.addAttribute("students", theStudents);
		return "Students";
	}
	
	@RequestMapping("/addStudent")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Student theStudent = new Student();
		
		theModel.addAttribute("students", theStudent);
		
		return "StudentForm";
	}
	
	@RequestMapping("/updateStudent")
	public String showFormForUpdate(@RequestParam("student_id") int theId,
			Model theModel) {
		 
		// get the Book from the service
		Student theStudent = studentService.findById(theId);
		
		// set Book as a model attribute to pre-populate the form
		theModel.addAttribute("students", theStudent);
		
		// send over to our form
		return "StudentForm";
	}
	
	@RequestMapping("/save")
	public String saveStudent(@RequestParam("student_id") int student_id,
			@RequestParam("first_name") String first_name,@RequestParam("last_name") String last_name,
			@RequestParam("course") String course, @RequestParam("country") String country) {

		System.out.println(student_id);
		Student theStudent;
		if(student_id!=0)
		{
			theStudent=studentService.findById(student_id);
			theStudent.setFirst_name(first_name);
			theStudent.setLast_name(last_name);
			theStudent.setCourse(course);
			theStudent.setCountry(country);
			}
		else
			theStudent=new Student(first_name,last_name,course,country);
		// save the Student
		studentService.save(theStudent);


		// use a redirect to prevent duplicate submissions
		return "redirect:/students/list";

	}

	

	@RequestMapping("/deleteStudent")
	public String delete(@RequestParam("student_id") int theId) {

		if(theId!=0)
		{
			Student theStudent=studentService.findById(theId);
			studentService.delete(theStudent);
		}
		
		// redirect to /Students/list
		return "redirect:/students/list";

	}
	
	@RequestMapping("/403")
	public ModelAndView accessDenied(Principal user)
	{
		ModelAndView mv=new ModelAndView();
		
		if(user!=null)
		{
			mv.addObject("msg", "Hi "+user.getName()+", you are not allowed to access this page");			
		}
		else
		{
			mv.addObject("msg", "Hi, you are not allowed to access this page");	
		}
		mv.setViewName("403");
		return mv;
	}

}
