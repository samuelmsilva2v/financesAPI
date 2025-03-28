package com.example.demo.application.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AuthenticateUserRequestDto {

	@Email(message = "Please enter a valid email adress.")
	@NotEmpty(message = "Please enter your access email.")
	private String email;
	
	@Size(min = 8, message = "Please enter your login password with at least 8 characters")
	@NotEmpty(message = "Please enter your login password.")
	private String password;
}
