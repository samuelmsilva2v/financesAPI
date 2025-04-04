package com.example.demo.domain.models.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.example.demo.domain.models.enums.BillType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table
@Data
public class Bill {

	@Id
	private UUID id;

	@Column(length = 100, nullable = false, unique = true)
	private String name;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date date;

	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal value;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private BillType type;

	@ManyToMany
	@JoinTable(name = "bill_category", joinColumns = @JoinColumn(name = "bill_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<Category> categories;
}
