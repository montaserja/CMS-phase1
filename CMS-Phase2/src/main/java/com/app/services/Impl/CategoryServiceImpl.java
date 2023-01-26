package com.app.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.exceptions.categoryExceptions.CategoryDuplicated;
import com.app.exceptions.categoryExceptions.CategoryNotExist;
import com.app.model.Category;
import com.app.repositories.CategoryRepository;
import com.app.services.CategoryService;

import jakarta.transaction.Transactional;

public class CategoryServiceImpl implements CategoryService {
	
	
	@Autowired
	private CategoryRepository categoryRepo;
	

	@Override
	@Transactional
	public void createCategory(String categoryName) throws CategoryDuplicated {
		Optional<Category> category = categoryRepo.findByName(categoryName);
		if(category.isPresent()) {
			throw new CategoryDuplicated("Category name duplicated!!");
		}
		Category categoryToSave = new Category();
		categoryToSave.setName(categoryName);
		categoryRepo.save(categoryToSave);	
	}

	@Override
	@Transactional
	public void deleteCategory(String categoryName) throws CategoryNotExist {
		Optional<Category> category = categoryRepo.findByName(categoryName);
		if(!category.isPresent()) {
			throw new CategoryNotExist("Category not exist!!");
		}
		categoryRepo.delete(category.get());	
	}

	@Override
	@Transactional
	public List<Category> getAllCategoies() {
		return categoryRepo.findAll();
	}

	@Override
	@Transactional
	public Category getCategoryByName(String categoryName) throws CategoryNotExist {
		return categoryRepo.findByName(categoryName).get();
	}

}
