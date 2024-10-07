package com.app.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = true)
	private String middleName;
	@Column(nullable = true)
	private String lastName;
	@Column(nullable = false)
	private long phoneNumber;
	@Column(nullable = true)
	private String emailId;
	
	public Student(){}
	
	public Student(String firstName,String middleName,String lastName,long phoneNumber,String emailId)
	{
		this.firstName=firstName;
		this.middleName=middleName;
		this.lastName=lastName;
		this.phoneNumber=phoneNumber;
		this.emailId=emailId;
	}
	
}
