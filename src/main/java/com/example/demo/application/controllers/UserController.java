package com.example.demo.application.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Operation(summary = "Serviço para cadastrar um usuário")
	@PostMapping("register")
	public void post() {
		// TODO
	}
	
	@Operation(summary = "Serviço para autenticar um usuário")
	@PostMapping("authenticate")
	public void authenticate() {
		// TODO
	}
}
