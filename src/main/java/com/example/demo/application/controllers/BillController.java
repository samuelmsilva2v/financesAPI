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

import com.example.demo.application.dtos.BillRequestDto;
import com.example.demo.application.dtos.BillResponseDto;
import com.example.demo.domain.services.interfaces.BillDomainService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/bill")
public class BillController {

	@Autowired
	private BillDomainService billDomainService;
	
	@Operation(summary = "Serviço para cadastrar uma nova conta")
	@PostMapping
	public ResponseEntity<BillResponseDto> post(@RequestBody BillRequestDto request) throws Exception {
		var response = billDomainService.create(request);
		return ResponseEntity.ok(response);
	}
	
	@Operation(summary = "Serviço para atualizar uma conta")
	@PutMapping("/{id}")
	public ResponseEntity<BillResponseDto> put(@PathVariable UUID id, @RequestBody BillRequestDto request) throws Exception {
		var response = billDomainService.update(id, request);
		return ResponseEntity.ok(response);
	}
	
	@Operation(summary = "Serviço para excluir uma conta")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable UUID id) throws Exception {
		var response = billDomainService.deleteById(id);
		return ResponseEntity.ok(response);
	}
	
	@Operation(summary = "Serviço para consultar uma conta através do ID")
	@GetMapping("/{id}")
	public ResponseEntity<BillResponseDto> getById(@PathVariable UUID id) throws Exception {
		var response = billDomainService.findById(id);
		return ResponseEntity.ok(response);
	}
	
	@Operation(summary = "Serviço para consultar todas as contas")
	@GetMapping
	public ResponseEntity<List<BillResponseDto>> getAll() throws Exception {
		var response = billDomainService.findAll();
		return ResponseEntity.ok(response);
	}
}
