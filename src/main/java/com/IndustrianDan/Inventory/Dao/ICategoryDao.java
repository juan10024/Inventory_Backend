package com.IndustrianDan.Inventory.Dao;

import org.springframework.data.repository.CrudRepository;

import com.IndustrianDan.Inventory.Model.Category;

public interface ICategoryDao extends CrudRepository<Category, Long>{
	
}
