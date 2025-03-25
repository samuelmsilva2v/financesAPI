package com.example.demo.domain.services.interfaces;

import java.util.List;
import java.util.UUID;

import com.example.demo.application.dtos.BillRequestDto;
import com.example.demo.application.dtos.BillResponseDto;

public interface BillDomainService {

	BillResponseDto create(BillRequestDto dto) throws Exception;
	
	BillResponseDto update(UUID id, BillRequestDto request) throws Exception;
	
	String deleteById(UUID id) throws Exception;
	
	BillResponseDto findById(UUID id) throws Exception;
	
	List<BillResponseDto> findAll() throws Exception;
}
