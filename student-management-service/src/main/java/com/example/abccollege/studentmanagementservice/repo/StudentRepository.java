package com.example.abccollege.studentmanagementservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.abccollege.studentmanagementservice.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

//	@Query("SELECT s FROM Student WHERE Student.name LIKE '%?1%' AND Student.department LIKE '%?2%'")
	List<Student> findByNameContains(String name);

}
