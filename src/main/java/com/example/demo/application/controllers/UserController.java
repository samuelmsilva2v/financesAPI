package com.example.demo.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.dtos.CreateUserRequestDto;
import com.example.demo.application.dtos.CreateUserResponseDto;
import com.example.demo.domain.services.interfaces.UserDomainService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserDomainService userDomainService;

	@Operation(summary = "Serviço para cadastrar um usuário")
	@PostMapping("register")
	public ResponseEntity<CreateUserResponseDto> post(@RequestBody @Valid CreateUserRequestDto request) throws Exception {
		var response = userDomainService.register(request);
		return ResponseEntity.ok(response);
	}
	
	@Operation(summary = "Serviço para autenticar um usuário")
	@PostMapping("authenticate")
	public void authenticate() throws Exception {
		// TODO
	}
}
