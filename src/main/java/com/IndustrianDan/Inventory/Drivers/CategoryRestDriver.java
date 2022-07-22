package com.IndustrianDan.Inventory.Drivers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IndustrianDan.Inventory.Response.CategoryResponseRest;
import com.IndustrianDan.Inventory.Services.ICategoryService;

@RestController
@RequestMapping("/api/v1") 
public class CategoryRestDriver {
	
	//fields
	@Autowired 
	private ICategoryService service;  
 
	@GetMapping("/categories")
	public ResponseEntity<CategoryResponseRest> searchCategorys()
	{
		ResponseEntity<CategoryResponseRest> response = service.search(); 
		return response; 
	} 
	
}
