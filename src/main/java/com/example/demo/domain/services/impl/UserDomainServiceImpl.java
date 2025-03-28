package com.example.demo.domain.services.impl;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.application.dtos.AuthenticateUserRequestDto;
import com.example.demo.application.dtos.AuthenticateUserResponseDto;
import com.example.demo.application.dtos.CreateUserRequestDto;
import com.example.demo.application.dtos.CreateUserResponseDto;
import com.example.demo.domain.models.entities.User;
import com.example.demo.domain.services.interfaces.UserDomainService;
import com.example.demo.infrastructure.components.SHA256Component;
import com.example.demo.infrastructure.repositories.UserRepository;

public class UserDomainServiceImpl implements UserDomainService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SHA256Component sha256Component;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CreateUserResponseDto register(CreateUserRequestDto request) throws Exception {

		if (userRepository.findByEmail(request.getEmail()) != null)
			throw new IllegalArgumentException("The provided email is already registered. Please try another one.");

		var user = new User();
		user.setId(UUID.randomUUID());
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(sha256Component.encrypt(request.getPassword()));

		userRepository.save(user);

		return modelMapper.map(user, CreateUserResponseDto.class);
	}

	@Override
	public AuthenticateUserResponseDto authenticate(AuthenticateUserRequestDto request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
