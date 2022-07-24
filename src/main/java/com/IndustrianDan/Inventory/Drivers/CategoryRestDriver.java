package com.IndustrianDan.Inventory.Drivers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IndustrianDan.Inventory.Model.Category;
import com.IndustrianDan.Inventory.Response.CategoryResponseRest;
import com.IndustrianDan.Inventory.Services.ICategoryService;

@RestController
@RequestMapping("/api/v1") 
public class CategoryRestDriver {
	
	//fields
	@Autowired 
	private ICategoryService service;  
	
	
	/**
	 * get all categories 
	 * @return response
	 */
	@GetMapping("/categories")
	public ResponseEntity<CategoryResponseRest> searchCategorys()
	{
		ResponseEntity<CategoryResponseRest> response = service.search(); 
		return response; 
	} 
	
	/**
	 * get categories by ID 
	 * @param id
	 * @return response 
	 */
	@GetMapping("/categories/{id}") 
	public ResponseEntity<CategoryResponseRest> searchCategorysById(@PathVariable Long id)
	{
		ResponseEntity<CategoryResponseRest> response = service.searchById(id);  
		return response; 
	} 
	
	/**
	 * save categories by ID 
	 * @param Category
	 * @return response  
	 */
	@PostMapping("/categories") 
	public ResponseEntity<CategoryResponseRest> save(@RequestBody Category category) 
	{  
		ResponseEntity<CategoryResponseRest> response = service.save(category);    
		return response; 
	}
	
	/**
	 * update categories 
	 * @param category
	 * @param id 
	 * @return response
	 */
	@PutMapping("/categories/{id}")  
	public ResponseEntity<CategoryResponseRest> update(@RequestBody Category category, @PathVariable Long id) 
	{  
		ResponseEntity<CategoryResponseRest> response = service.update(category, id);     
		return response; 
	}
	
	/**
	 * Delete categories by id
	 * @param id
	 * @return response
	 */
	@DeleteMapping("/categories/{id}")
	public ResponseEntity<CategoryResponseRest> delete(@PathVariable Long id) 
	{  
		ResponseEntity<CategoryResponseRest> response = service.deleteById(id);     
		return response;  
	}
}
