package com.example.demo.application.dtos;

import lombok.Data;

@Data
public class CreateUserRequestDto {

	private String name;
	private String email;
	private String password;
}
