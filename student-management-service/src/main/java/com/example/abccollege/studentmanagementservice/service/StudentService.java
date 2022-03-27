package com.example.abccollege.studentmanagementservice.service;

import java.util.List;

import com.example.abccollege.studentmanagementservice.entity.Student;

public interface StudentService {

	List<Student> getAllStudents();

	Student findById(Long id);

	void saveStudentDetails(Student student);

	void deleteStudentdetails(Student student);

	List<Student> searchStudentsInDB(String name);

}
