package com.example.demo.application.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryRequestDto {

	@NotBlank(message = "Please provide the category name.")
	@Size(max = 50, message = "The category name must have a maximum of 50 characters.")
	private String name;
}
