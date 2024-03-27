package com.blogger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogger.payloads.Apiresponse;
import com.blogger.payloads.CategoryDTO;
import com.blogger.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	// create category
	@PostMapping("/createcategory")
	public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {

		CategoryDTO createCategory = this.categoryService.createCategory(categoryDTO);
		return new ResponseEntity<CategoryDTO>(createCategory, HttpStatus.CREATED);
	}

	// Update category
	@PutMapping("/updatecategory/{catId}")
	public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO,
			@PathVariable Integer catId) {

		CategoryDTO updatedCategory = this.categoryService.updateCategory(categoryDTO, catId);
		return new ResponseEntity<CategoryDTO>(updatedCategory, HttpStatus.OK);
	}

	// get by id category
	@GetMapping("/getcategorybyid/{catId}")
	public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Integer catId) {

		CategoryDTO getCategory = this.categoryService.getCategory(catId);
		return new ResponseEntity<CategoryDTO>(getCategory, HttpStatus.OK);
	}

	// get all category
	@GetMapping("/getallcategories")
	public ResponseEntity<List<CategoryDTO>> getAllCategories() {

		List<CategoryDTO> category = this.categoryService.getCategory();
		return ResponseEntity.ok(category);
	}

	// delete by id category
	@DeleteMapping("/deletecategory/{catId}")
	public ResponseEntity<Apiresponse> deletecategory(@PathVariable Integer catId) {

		this.categoryService.deleteCategory(catId);
		return new ResponseEntity<Apiresponse>(new Apiresponse("Category is deleted sucessfully !!", true),
				HttpStatus.OK);
	}
}
