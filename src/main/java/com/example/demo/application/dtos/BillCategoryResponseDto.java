package com.example.demo.application.dtos;

import lombok.Data;

@Data
public class BillCategoryResponseDto {

	private BillResponseDto bill;
	private CategoryResponseDto category;
}
