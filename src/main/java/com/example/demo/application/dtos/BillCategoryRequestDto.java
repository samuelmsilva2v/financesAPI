package com.example.demo.application.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BillCategoryRequestDto {

	@NotNull(message = "Please provide the Bill ID")
	private UUID billID;
	
	@NotNull(message = "Please provide the Category ID")
	private UUID categoryId;
}
