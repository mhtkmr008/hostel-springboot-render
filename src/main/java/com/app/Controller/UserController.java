package com.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.Authenticate;
import com.app.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:3000")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<?>AuthenticateUser(@RequestBody Authenticate auth)
	{
		System.out.println("in responseEntity UserLogin (1)");
		String un=auth.getUsername();
		String pass=auth.getPassword();
		
		System.out.println(un);
		System.out.println(pass);
		boolean isAuthenticated=userService.getAuthenticate(un,pass);
		
		System.out.println("in responseEntity UserLogin (1)");
		
		if(isAuthenticated) {
			return ResponseEntity.ok("Login Successfull");
		}
		else
		{
			return ResponseEntity.status(401).body("Invalid credentials");
		}
	}
}