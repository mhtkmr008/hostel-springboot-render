package com.app.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	
	@Column(name="username",unique=true,nullable=false)
	private String username;
	
	@Column(name="password",nullable=false)
	private String password;
}
