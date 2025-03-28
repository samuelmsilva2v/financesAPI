package com.example.demo.application.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class AuthenticateUserResponseDto {

	private UUID id;
	private String name;
	private String email;
	private String token;
}
