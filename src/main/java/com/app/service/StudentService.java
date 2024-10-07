package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.app.dto.StudentDTO;
import com.app.entities.Student;

public interface StudentService {

	boolean addStudent(String firstName,String middleName,String lastName,long phoneNumber,String emailId);
	
	public List<Student> listAllStudents();

	public void deleteStudent(int id);

	public Optional<Student> getById(int id);

	public Optional<Student> updateStudent(Integer id, StudentDTO student);

	//Optional<Student> findByName(String name);
}
