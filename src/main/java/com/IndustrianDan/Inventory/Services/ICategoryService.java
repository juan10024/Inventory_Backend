package com.IndustrianDan.Inventory.Services;

import org.springframework.http.ResponseEntity;

import com.IndustrianDan.Inventory.Model.Category;
import com.IndustrianDan.Inventory.Response.CategoryResponseRest;

public interface ICategoryService {

	public ResponseEntity<CategoryResponseRest> search(); 
	public ResponseEntity<CategoryResponseRest> searchById(Long id);  
	public ResponseEntity<CategoryResponseRest> save(Category category); 
	public ResponseEntity<CategoryResponseRest> update(Category category, Long id);  
	public ResponseEntity<CategoryResponseRest> deleteById(Long id); 
}
