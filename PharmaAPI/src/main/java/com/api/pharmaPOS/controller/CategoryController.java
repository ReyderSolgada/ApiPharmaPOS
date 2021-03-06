package com.api.pharmaPOS.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.api.pharmaPOS.entity.Category;
import com.api.pharmaPOS.entity.Supplier;
import com.api.pharmaPOS.service.CategoryService;

@RestController
@RequestMapping("/api")

public class CategoryController {

	// Dependency injection

	@Autowired
	private CategoryService categoryService;

	// Method to get all categories

	@RequestMapping(value="/categories",method=RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<List<Category>> getAllCategories(){
		List<Category> lista=new ArrayList<Category>();
		lista= categoryService.getAllCategories();

		return  new ResponseEntity<List<Category>>(lista,HttpStatus.OK);
	}

	// Method to get categories by id

	@RequestMapping("/categories/{id}")
	public Optional<Category> getCategory(@PathVariable int id) {
		return categoryService.getCategory(id);
	}

	// Method to add a category

	@RequestMapping(method = RequestMethod.POST, value = "/categories")
	public void addCategory(@RequestBody Category category) {
		categoryService.addCategory(category);
	}

	// Method to update a category

	@RequestMapping(method = RequestMethod.PUT, value = "/categories/{id}")
	public void updateCategory(@RequestBody Category category, @PathVariable int id) {
		categoryService.updateCategory(id, category);
	}

	// Method to delete a category

	@RequestMapping(method = RequestMethod.DELETE, value = "/categories/{id}")
	public void deleteCategory(@PathVariable int id) {
		categoryService.deleteCategory(id);
	}

}
