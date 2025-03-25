package com.example.demo.application.dtos;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class BillResponseDto {

	private UUID id;
	private String name;
	private Instant date;
	private Double value;
	private String type;
	private List<CategoryResponseDto> categoria;
}
