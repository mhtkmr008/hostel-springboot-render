package com.app.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.StudentDTO;
import com.app.entities.Student;
import com.app.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:3000")

public class StudentController {
	
	
	@Autowired
	private StudentService studentService;
	@PostMapping("/add")
	public ResponseEntity<String> addStudent(@RequestBody Student student){
		String firstName=student.getFirstName();
		String middleName=student.getMiddleName();
		String lastName=student.getLastName();
		long phoneNumber=student.getPhoneNumber();
		String emailId=student.getEmailId();
		
		System.out.println(firstName+","+middleName+","+lastName+","+phoneNumber+","+emailId);
		
		boolean addStudent=studentService.addStudent(firstName, middleName, lastName, phoneNumber, emailId);
		
		if(addStudent)
		{
			return ResponseEntity.ok("Student Details added successfully");
		}
		else
		{
			return ResponseEntity.status(401).body("Student details not added");
		}
		}
	@GetMapping("/getAllStudents")
	public ResponseEntity <List<Student>> listAllStudents()
	{
		System.out.println("In Students get all students");
		return ResponseEntity.ok(studentService.listAllStudents());
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<List<Student>>deleteStudent(@PathVariable int id)
	{
		System.out.println("In deleteStudent");
		studentService.deleteStudent(id);
		List<Student> updatedStudentList=studentService.listAllStudents();
		return ResponseEntity.ok(updatedStudentList);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Student>getById(@PathVariable int id)
	{
		System.out.println("In get By Id");
		Optional<Student> student=studentService.getById(id);
		if(student.isPresent())
		{
			return ResponseEntity.ok(student.get());
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Integer id,@RequestBody StudentDTO student)
	{
		//System.out.println(student.getFirstName()+" "+student.getMiddleName()+" "+student.getLastName()+" "+student.getPhoneNumber()+" "+student.getEmailId());
		System.out.println("In Student controller for updateStudent before going to Service");
		Optional<Student> updatedStudent=studentService.updateStudent(id, student);
		return updatedStudent.isPresent()? ResponseEntity.ok(updatedStudent.get()):ResponseEntity.notFound().build();
	}
	
//	@GetMapping("/findStudentByName/{name}")
//	public ResponseEntity<Student>getByName(@PathVariable String name)
//	{
//		System.out.println("In Student Controller's find by name begins");
//		Optional<Student> student=studentService.findByName(name);
//		if(student.isPresent())
//		{
//			return ResponseEntity.ok(student.get());
//		}
//		else
//		{
//		return ResponseEntity.notFound().build();
//		}
//	}
}
