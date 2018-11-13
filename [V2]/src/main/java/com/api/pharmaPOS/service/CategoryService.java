package com.api.pharmaPOS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.pharmaPOS.entity.Category;
import com.api.pharmaPOS.repository.CategoryRepository;

@Service

public class CategoryService {

	/*
	 * When Spring creates an instance of CategoryService, the CategoryRepository
	 * class is going to be injected.
	 */

	@Autowired
	private CategoryRepository categoryRepository;

	// Method to list all categories

	public List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<>();
		categoryRepository.findAll().forEach(categories::add);
		return categories;
	}

	// Method to add a new category

	public void addCategory(Category category) {
		categoryRepository.save(category);
	}

	// Method to find a category by id

	public Optional<Category> getCategory(int id) {
		return categoryRepository.findById(id);
	}

	// Method to update a category

	public void updateCategory(int id, Category category) {
		categoryRepository.save(category);
	}

	// Method to delete a category

	public void deleteCategory(int id) {
		categoryRepository.deleteById(id);
	}

}
