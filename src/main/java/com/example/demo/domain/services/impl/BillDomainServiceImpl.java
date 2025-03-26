package com.example.demo.domain.services.impl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.application.dtos.BillRequestDto;
import com.example.demo.application.dtos.BillResponseDto;
import com.example.demo.domain.models.entities.Bill;
import com.example.demo.domain.services.interfaces.BillDomainService;
import com.example.demo.infrastructure.repositories.BillRepository;

@Service
public class BillDomainServiceImpl implements BillDomainService {

	@Autowired
	private BillRepository billRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BillResponseDto create(BillRequestDto request) throws Exception {
		
		if(billRepository.existsByName(request.getName()))
			throw new IllegalArgumentException("There is already a bill registered with that name. Please try another one.");

		var bill = modelMapper.map(request, Bill.class);
		bill.setId(UUID.randomUUID());

		billRepository.save(bill);

		return modelMapper.map(bill, BillResponseDto.class);
	}

	@Override
	public BillResponseDto update(UUID id, BillRequestDto request) throws Exception {

		var bill = billRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Bill with ID " + id + " not found."));
		
		if(billRepository.existsByName(request.getName()))
			throw new IllegalArgumentException("There is already a bill registered with that name. Please try another one.");

		bill.setName(request.getName());
		bill.setDate(request.getDate());
		bill.setValue(request.getValue());
		bill.setType(request.getType());

		billRepository.save(bill);

		return modelMapper.map(bill, BillResponseDto.class);
	}

	@Override
	public String deleteById(UUID id) throws Exception {

		var bill = billRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Bill with ID " + id + " not found."));

		billRepository.delete(bill);
		
		return "The bill has been deleted successfully.";
	}

	@Override
	public BillResponseDto findById(UUID id) throws Exception {

		var bill = billRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Bill with ID " + id + " not found."));

		return modelMapper.map(bill, BillResponseDto.class);
	}

	@Override
	public List<BillResponseDto> findAll() throws Exception {
		return billRepository.findAll().stream().map(bill -> modelMapper.map(bill, BillResponseDto.class)).toList();
	}

}
