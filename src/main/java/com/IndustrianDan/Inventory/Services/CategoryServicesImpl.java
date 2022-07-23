package com.IndustrianDan.Inventory.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

		@Override
		@Transactional(readOnly = true) 
		public ResponseEntity<CategoryResponseRest> searchById(Long id)
		{
			CategoryResponseRest response = new CategoryResponseRest();  
			List<Category> list = new ArrayList<>();  
			
			try 
			{
				
				Optional<Category> category = categoryDao.findById(id);      
				if(category.isPresent()) 
				{
					list.add(category.get()); 
					response.getCategoryResponse().setCategory(list);
					response.setMetadata( " Respuesta bien " , " 00 ", " Categoria encontrada " ); 
				}
				else 
				{
					response.setMetadata( " Respuesta mal " , " -1 ", " La categoría no ha sido encontrada " ); 
					return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.NOT_FOUND); 	
				}
				
			} 
			catch(Exception e) 
			{
				response.setMetadata( " Respuesta mal " , " -1 ", " Error al Consultar por ID ");
				e.getStackTrace();
				return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
		}

		@Override 
		@Transactional 
		public ResponseEntity<CategoryResponseRest> save(Category category) 
		{
			CategoryResponseRest response = new CategoryResponseRest();  
			List<Category> list = new ArrayList<>();  
			
			try 
			{ 
				Category categorySaved = categoryDao.save(category);
				if(categorySaved != null) 
				{
					list.add(categorySaved);   
					response.getCategoryResponse().setCategory(list); 
					response.setMetadata( " Respuesta bien " , " 00 ", " La categoría ha sido guardada con éxito " ); 
				}
				else 
				{
					response.setMetadata( " Respuesta mal " , " -1 ", " La categoría no ha sido guardada " ); 
					return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.BAD_REQUEST);   
				}
			} 
			catch(Exception e) 
			{
				response.setMetadata( " Respuesta mal " , " -1 ", " Error al Grabar la categoría ");
				e.getStackTrace();
				return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);	
			}
			
			return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK); 
		} 

}
