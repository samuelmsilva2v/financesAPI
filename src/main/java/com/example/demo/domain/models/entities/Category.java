package com.example.demo.domain.models.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Category {

	@Id
	private UUID id;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@ManyToMany(mappedBy = "category")
	private List<Bill> bills;
}
