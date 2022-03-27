package com.example.abccollege.studentmanagementservice.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.abccollege.studentmanagementservice.entity.Student;
import com.example.abccollege.studentmanagementservice.repo.StudentRepository;
import com.example.abccollege.studentmanagementservice.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {
//		Set<Student> students = new HashSet<Student>();
//		this.studentRepository.findAll().forEach(student -> students.add(student));
		return this.studentRepository.findAll();
	}

	@Override
	public Student findById(Long id) {
		// TODO Auto-generated method stub
		return this.studentRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Students with given Id doesn't exist"));
	}

	@Override
	public void saveStudentDetails(Student student) {
		this.studentRepository.save(student);

	}

	@Override
	public void deleteStudentdetails(Student student) {
		this.studentRepository.delete(student);

	}

	@Override
	public List<Student> searchStudentsInDB(String name) {
		return this.studentRepository.findByNameContains(name);
	}

}
