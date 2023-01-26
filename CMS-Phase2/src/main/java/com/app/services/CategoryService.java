package com.app.services;

import java.util.List;

import com.app.exceptions.categoryExceptions.CategoryDuplicated;
import com.app.exceptions.categoryExceptions.CategoryNotExist;
import com.app.model.Category;

public interface CategoryService {
	public void createCategory(String categoryName) throws CategoryDuplicated;
	public void deleteCategory(String categoryName) throws CategoryNotExist;
	public List<Category> getAllCategoies();
	public Category getCategoryByName(String categoryName) throws CategoryNotExist;

}
