package com.example.demo.application.dtos;

import java.math.BigDecimal;
import java.util.Date;

import com.example.demo.domain.models.enums.BillType;

import lombok.Data;

@Data
public class BillRequestDto {

	private String name;
	private Date date;
	private BigDecimal value;
	private BillType type;
}
