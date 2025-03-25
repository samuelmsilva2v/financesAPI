package com.example.demo.domain.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.application.dtos.BillCategoryRequestDto;
import com.example.demo.application.dtos.BillCategoryResponseDto;
import com.example.demo.application.dtos.BillResponseDto;
import com.example.demo.application.dtos.CategoryResponseDto;
import com.example.demo.domain.services.interfaces.BillCategoryDomainService;
import com.example.demo.infrastructure.repositories.BillRepository;
import com.example.demo.infrastructure.repositories.CategoryRepository;

@Service
public class BillCategoryDomainServiceImpl implements BillCategoryDomainService {

	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public BillCategoryResponseDto create(BillCategoryRequestDto request) throws Exception {
		
		var bill = billRepository.findById(request.getBillID())
				.orElseThrow(() -> new IllegalArgumentException("Bill with ID " + request.getBillID() + " not found."));
		
		var category = categoryRepository.findById(request.getCategoryId())
				.orElseThrow(() -> new IllegalArgumentException("Category with ID " + request.getCategoryId() + " not found."));
		
		bill.getCategories().add(category);
		
		billRepository.save(bill);
		
		var response = new BillCategoryResponseDto();
		response.setBill(modelMapper.map(bill, BillResponseDto.class));
		response.setCategory(modelMapper.map(category, CategoryResponseDto.class));
		
		return response;
	}
}
