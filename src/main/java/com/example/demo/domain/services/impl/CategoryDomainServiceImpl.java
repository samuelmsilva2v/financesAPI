package com.example.demo.domain.services.impl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.application.dtos.CategoryRequestDto;
import com.example.demo.application.dtos.CategoryResponseDto;
import com.example.demo.domain.models.entities.Category;
import com.example.demo.domain.services.interfaces.CategoryDomainService;
import com.example.demo.infrastructure.repositories.CategoryRepository;

@Service
public class CategoryDomainServiceImpl implements CategoryDomainService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryResponseDto create(CategoryRequestDto request) throws Exception {

		var category = modelMapper.map(request, Category.class);
		category.setId(UUID.randomUUID());

		categoryRepository.save(category);

		return modelMapper.map(category, CategoryResponseDto.class);
	}

	@Override
	public CategoryResponseDto update(UUID id, CategoryRequestDto request) throws Exception {

		var category = categoryRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Category with ID " + id + " not found."));

		category.setName(request.getName());

		categoryRepository.save(category);

		return modelMapper.map(category, CategoryResponseDto.class);
	}

	@Override
	public CategoryResponseDto deleteById(UUID id) throws Exception {

		var category = categoryRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Category with ID " + id + " not found."));

		categoryRepository.delete(category);

		return modelMapper.map(category, CategoryResponseDto.class);
	}

	@Override
	public CategoryResponseDto findById(UUID id) throws Exception {

		var category = categoryRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Category with ID " + id + " not found."));

		return modelMapper.map(category, CategoryResponseDto.class);
	}

	@Override
	public List<CategoryResponseDto> findAll() throws Exception {

		return categoryRepository.findAll().stream()
				.map(category -> modelMapper.map(category, CategoryResponseDto.class)).toList();
	}
}
