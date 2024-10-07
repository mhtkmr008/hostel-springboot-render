package com.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class StudentDTO {
	
	public String firstName;
	public String middleName;
	public String lastName;
	public long phoneNumber;
	public String emailId;
}
