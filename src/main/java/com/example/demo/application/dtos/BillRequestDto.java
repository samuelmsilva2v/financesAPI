package com.example.demo.application.dtos;

import java.math.BigDecimal;
import java.util.Date;

import com.example.demo.domain.models.enums.BillType;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BillRequestDto {

	@NotBlank(message = "Please provide the category name.")
	@Size(max = 100, message = "The category name must have a maximum of 100 characters.")
	private String name;
	
	@NotNull(message = "Please provide the date.")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date date;
	
	@NotNull(message = "Please provide the value.")
	private BigDecimal value;
	
	@NotNull(message = "Please provide the Bill Type.")
	private BillType type;
}
