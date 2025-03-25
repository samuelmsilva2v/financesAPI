package com.example.demo.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.dtos.BillCategoryRequestDto;
import com.example.demo.application.dtos.BillCategoryResponseDto;
import com.example.demo.domain.services.interfaces.BillCategoryDomainService;

@RestController
@RequestMapping("/api/bill-category")
public class BillCategoryController {

	@Autowired
	private BillCategoryDomainService billCategoryDomainService;
	
	@PostMapping
	public ResponseEntity<BillCategoryResponseDto> post(@RequestBody BillCategoryRequestDto request) throws Exception {
		var response = billCategoryDomainService.create(request);
		return ResponseEntity.ok(response);
	}
}
