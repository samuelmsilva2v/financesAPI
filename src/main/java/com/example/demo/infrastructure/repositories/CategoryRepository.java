package com.example.demo.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.models.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

	boolean existsByName(String nome);
}
