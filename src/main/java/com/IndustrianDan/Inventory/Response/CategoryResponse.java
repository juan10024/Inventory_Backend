package com.IndustrianDan.Inventory.Response;

import java.util.List;

import com.IndustrianDan.Inventory.Model.Category;

import lombok.Data;

@Data 
public class CategoryResponse {

	private List<Category> category; 
	
}
  