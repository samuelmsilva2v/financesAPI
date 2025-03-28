package com.example.demo.application.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateUserRequestDto {

	@Size(min = 4, max = 100, message = "Please enter a name between 4 and 100 characters.")
	@NotEmpty(message = "Please enter your name.")
	private String name;

	@Email(message = "Please enter a valid email adress.")
	@NotEmpty(message = "Please enter your access email.")
	private String email;

	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?!.*\\s).{8,}$", message = "Please enter a password containing lowercase letters, uppercase letters, numbers, symbols, and at least 8 characters.")
	@NotEmpty(message = "Please enter your login password.")
	private String password;
}
