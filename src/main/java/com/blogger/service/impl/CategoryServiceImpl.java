package com.blogger.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogger.Repo.CategoryRepo;
import com.blogger.entity.Category;
import com.blogger.exception.ResourceNotFoundException;
import com.blogger.payloads.CategoryDTO;
import com.blogger.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDTO) {

		Category cat = this.modelMapper.map(categoryDTO, Category.class);

		Category save = this.categoryRepo.save(cat);

		return this.modelMapper.map(save, CategoryDTO.class);
	}

	@Override
	public CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId) {

		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category id", categoryId));

		cat.setCategoryTitle(categoryDTO.getCategorytitle());
		cat.setCategoryDiscription(categoryDTO.getCategorydiscription());

		Category updatedcat = this.categoryRepo.save(cat);
		return this.modelMapper.map(updatedcat, CategoryDTO.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {

		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category id", categoryId));

		this.categoryRepo.delete(cat);

	}

	@Override
	public CategoryDTO getCategory(Integer categoryId) {

		Category Cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category id", categoryId));

		return this.modelMapper.map(Cat, CategoryDTO.class);

	}

	@Override
	public List<CategoryDTO> getCategory() {

		List<Category> categories = this.categoryRepo.findAll();

		List<CategoryDTO> cagtegoryList = categories.stream().map((cat) -> this.modelMapper.map(cat, CategoryDTO.class))
				.collect(Collectors.toList());

		return cagtegoryList;
	}
}
