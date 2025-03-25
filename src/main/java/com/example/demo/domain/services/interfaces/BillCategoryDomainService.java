package com.example.demo.domain.services.interfaces;

import com.example.demo.application.dtos.BillCategoryRequestDto;
import com.example.demo.application.dtos.BillCategoryResponseDto;

public interface BillCategoryDomainService {

	BillCategoryResponseDto create(BillCategoryRequestDto request) throws Exception;
}
