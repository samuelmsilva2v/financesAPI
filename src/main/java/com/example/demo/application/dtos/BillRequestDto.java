package com.example.demo.application.dtos;

import java.time.Instant;

import lombok.Data;

@Data
public class BillRequestDto {

	private String name;
	private Instant date;
	private Double value;
	private String type;
}
