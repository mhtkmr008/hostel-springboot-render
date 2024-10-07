package com.app.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.dao.StudentDao;
import com.app.dto.StudentDTO;
import com.app.entities.Student;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private ModelMapper mapper;
	@Override
	public boolean addStudent(String firstName, String middleName, String lastName, long phoneNumber, String emailId) {
		try {
			Student student=new Student(firstName,middleName,lastName,phoneNumber,emailId);
			studentDao.save(student);
			return true;
		}catch(Exception e) {return false;}
		
	}
	@Override
	public List<Student> listAllStudents() {
		System.out.println("In Student Service Implimentation for findAll before going to JPA");
		return studentDao.findAll();
	}
	@Override
	public void deleteStudent(int id) {
		System.out.println("In Student Service Implimentation for deleteByID before going to JPA");
		studentDao.deleteById(id);
	}
	@Override
	public Optional<Student> getById(int id) {
		System.out.println("In Student Service Implimentation for getByID before going to JPA");
		return studentDao.findById(id);
		 
	}
	@Override
	public Optional<Student> updateStudent(Integer id, StudentDTO student) {
		Student oldStudent =studentDao.findById(id).orElseThrow(()->new RuntimeException("Student id not found"));
		mapper.map(student, oldStudent);
		studentDao.save(oldStudent);
		System.out.println("After mapping");
		Optional<Student> updatedStudent= studentDao.findById(id);
		return updatedStudent;
	}
//	@Override
//	public Optional<Student> findByName(String name) {
//		System.out.println("In Student ServiceImpl before jpa");
//		return studentDao.findByName(name);
//	}

}
