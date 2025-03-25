package com.example.demo.application.dtos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class BillResponseDto {

	private UUID id;
	private String name;
	private Date date;
	private BigDecimal value;
	private String type;
	private List<CategoryResponseDto> categories;
}
