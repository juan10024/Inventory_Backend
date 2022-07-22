package com.IndustrianDan.Inventory.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.IndustrianDan.Inventory.Dao.ICategoryDao;
import com.IndustrianDan.Inventory.Model.Category;
import com.IndustrianDan.Inventory.Response.CategoryResponseRest;

@Service 
public class CategoryServicesImpl implements ICategoryService {
	
		//fields
		@Autowired 
		private ICategoryDao categoryDao ; 
	
		@Override
		@Transactional(readOnly = true) 
		public ResponseEntity<CategoryResponseRest> search() 
		{ 
			CategoryResponseRest response = new CategoryResponseRest(); 
			
			try 
			{
				List<Category> category = (List<Category>) categoryDao.findAll(); 
				response.getCategoryResponse().setCategory(category); 
				response.setMetadata( " Respuesta bien " , " 00 ", " Respuesta exitosa "); 
			} 
			catch(Exception e) 
			{
				response.setMetadata( " Respuesta mal " , " -1 ", " Error al Consultar ");
				e.getStackTrace();
				return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);    
			}
			
			return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);      
		}

}
