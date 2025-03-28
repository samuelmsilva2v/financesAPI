package com.example.demo.domain.services.interfaces;

import com.example.demo.application.dtos.AuthenticateUserRequestDto;
import com.example.demo.application.dtos.AuthenticateUserResponseDto;
import com.example.demo.application.dtos.CreateUserRequestDto;
import com.example.demo.application.dtos.CreateUserResponseDto;

public interface UserDomainService {

	CreateUserResponseDto register(CreateUserRequestDto request) throws Exception;
	
	AuthenticateUserResponseDto authenticate(AuthenticateUserRequestDto request) throws Exception;
}
