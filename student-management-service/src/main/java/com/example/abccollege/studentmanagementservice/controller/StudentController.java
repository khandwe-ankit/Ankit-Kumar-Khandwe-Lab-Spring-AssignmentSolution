package com.example.abccollege.studentmanagementservice.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.abccollege.studentmanagementservice.entity.Student;
import com.example.abccollege.studentmanagementservice.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/list")
	public String fetchAllStudents(Model model) {
		List<Student> students = studentService.getAllStudents();

		model.addAttribute("students", students);
		return "student-list";

	}

	@RequestMapping("/add")
	public String addStudent(Model model) {

		// create model attribute to bind form data
		Student student = new Student();

		model.addAttribute("Student", student);

		return "student-form";
	}

	@RequestMapping("/save")
	public String saveStudent(
			@RequestParam(name = "id", defaultValue = "0") Long id, 
			@RequestParam("name") String name,
	        @RequestParam("department") String department, 
	        @RequestParam("country") String country) {

		// create model attribute to bind form data
		Student student;
		if (id != 0) {
			student = studentService.findById(id);
			student.setName(name);
			student.setDepartment(department);
			student.setCountry(country);
		} else
			student = new Student(name, department, country);
		studentService.saveStudentDetails(student);

		return "redirect:/students/list";
	}

	@RequestMapping("/update")
	public String updateStudentDetails(@RequestParam("id") Long id, Model model) {

		Student student = studentService.findById(id);
		model.addAttribute("student", student);

		return "student-form";
	}

	@RequestMapping("/delete")
	public String deleteStudentDetails(@RequestParam("id") Long id) {

		Student student = studentService.findById(id);
		studentService.deleteStudentdetails(student);

		return "redirect:/students/list";
	}

	@RequestMapping("/search")
	public String searchStudentDetails(@RequestParam("name") String name,
	        // @RequestParam("department") String department,
	        Model model) {
		if (name.trim().isEmpty())
//				&& department.trim().isEmpty()) 
		{
			return "redirect:/students/list";
		} else {
			List<Student> students = studentService.searchStudentsInDB(name);
			Student searchedStudentData = new Student(name, null, null);
			model.addAttribute("searchedStudentData", searchedStudentData);
			model.addAttribute("students", students);
			return "student-list";
		}

	}

	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to perform this action! Please reach out to the Adminitrator");
		} else {
			model.addObject("msg", "you do not have permission to perform this action! Please reach out to the Adminitrator");
		}

		model.setViewName("403");
		return model;

	}
}
