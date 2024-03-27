package com.blogger.service;

import java.util.List;

import com.blogger.payloads.CategoryDTO;

public interface CategoryService {

	CategoryDTO createCategory(CategoryDTO categoryDTO);
	
	CategoryDTO updateCategory(CategoryDTO categoryDTO,Integer categoryId);
	
	void deleteCategory(Integer categoryId);
	
	CategoryDTO getCategory(Integer categoryId);
	
	List<CategoryDTO> getCategory();
	
}
