package com.example.demo.domain.services.interfaces;

import java.util.List;
import java.util.UUID;

import com.example.demo.application.dtos.CategoryRequestDto;
import com.example.demo.application.dtos.CategoryResponseDto;

public interface CategoryDomainService {

	CategoryResponseDto create(CategoryRequestDto request) throws Exception;
	
	CategoryResponseDto update(UUID id, CategoryRequestDto request) throws Exception;
	
	CategoryResponseDto deleteById(UUID id) throws Exception;
	
	CategoryResponseDto findById(UUID id) throws Exception;
	
	List<CategoryResponseDto> findAll() throws Exception;
}
