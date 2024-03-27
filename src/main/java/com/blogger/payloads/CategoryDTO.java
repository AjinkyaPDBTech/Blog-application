package com.blogger.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoryDTO {

	private Integer categoryID;

	@NotBlank
	@Size(min = 4, max = 20, message = "Minimum size of category title is 4")
	private String categorytitle;

	@NotBlank
	@Size(min = 10, max = 50,message = "Minimum size of category title is 10")
	private String categorydiscription;

	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategorytitle() {
		return categorytitle;
	}

	public void setCategorytitle(String categorytitle) {
		this.categorytitle = categorytitle;
	}

	public String getCategorydiscription() {
		return categorydiscription;
	}

	public void setCategorydiscription(String categorydiscription) {
		this.categorydiscription = categorydiscription;
	}

	public CategoryDTO(Integer categoryID, String categorytitle, String categorydiscription) {
		super();
		this.categoryID = categoryID;
		this.categorytitle = categorytitle;
		this.categorydiscription = categorydiscription;
	}

	public CategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
