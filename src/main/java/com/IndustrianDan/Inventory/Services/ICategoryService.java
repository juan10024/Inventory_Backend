package com.IndustrianDan.Inventory.Services;

import org.springframework.http.ResponseEntity;

import com.IndustrianDan.Inventory.Response.CategoryResponseRest;

public interface ICategoryService {

	public ResponseEntity<CategoryResponseRest> search(); 
	public ResponseEntity<CategoryResponseRest> searchById(Long id);  
}
