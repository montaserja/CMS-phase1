package com.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	public Optional<Category> findByName(String name);

}
