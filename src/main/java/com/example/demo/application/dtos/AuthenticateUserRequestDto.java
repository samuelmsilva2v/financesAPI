package com.example.demo.application.dtos;

import lombok.Data;

@Data
public class AuthenticateUserRequestDto {

	private String email;
	private String senha;
}
