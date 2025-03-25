package com.example.demo.application.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.dtos.CategoryRequestDto;
import com.example.demo.application.dtos.CategoryResponseDto;
import com.example.demo.domain.services.interfaces.CategoryDomainService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryDomainService categoryDomainService;
	
	@Operation(summary = "Serviço para cadastrar uma nova categoria")
	@PostMapping
	public ResponseEntity<CategoryResponseDto> post(@RequestBody CategoryRequestDto request) throws Exception {
		var response = categoryDomainService.create(request);
		return ResponseEntity.ok(response);
	}
	
	@Operation(summary = "Serviço para atualizar uma categoria")
	@PutMapping("/{id}")
	public ResponseEntity<CategoryResponseDto> put(@PathVariable UUID id, @RequestBody CategoryRequestDto request) throws Exception {
		var response = categoryDomainService.update(id, request);
		return ResponseEntity.ok(response);
	}
	
	@Operation(summary = "Serviço para excluir uma categoria")
	@DeleteMapping("/{id}")
	public ResponseEntity<CategoryResponseDto> delete(@PathVariable UUID id) throws Exception {
		var response = categoryDomainService.deleteById(id);
		return ResponseEntity.ok(response);
	}
	
	@Operation(summary = "Serviço para consultar uma categoria através do ID")
	@GetMapping("/{id}")
	public ResponseEntity<CategoryResponseDto> getById(@PathVariable UUID id) throws Exception {
		var response = categoryDomainService.findById(id);
		return ResponseEntity.ok(response);
	}
	
	@Operation(summary = "Serviço para consultar todas as categorias")
	@GetMapping
	public ResponseEntity<List<CategoryResponseDto>> getAll() throws Exception {
		var response = categoryDomainService.findAll();
		return ResponseEntity.ok(response);
	}
}
